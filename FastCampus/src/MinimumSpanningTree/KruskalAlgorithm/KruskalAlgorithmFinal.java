package MinimumSpanningTree.KruskalAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KruskalAlgorithmFinal {

	public HashMap<String, String> parent = new HashMap<String,String>(); //<특정 노드, 이 특정 노드의 부모노드 및 루트노드>
	public HashMap<String, Integer> rank = new HashMap<String,Integer>(); //<특정 노드, 이 특정 노드의 rank정보>
	
	//파리미터로 받은 노드의 루트노드를 반환해주는 메서드
	public String find(String node) {
		//path compression기법 -> 내 부모노드가 루트노드가 아니라면, 루트노드를 일단 찾고, 거쳐간 노드들을 자식노드로 만듬 -> rank를 낮춰주는 역할
		if(this.parent.get(node) != node) { //루트노드인지 아닌지 체크하는 방법, 파라미터로 받은 node의 부모가, 결국 자기자신(파라미터로 받은 node)라면, 이게 결국 루트노드임
			this.parent.put(node, find(this.parent.get(node)));
		}
		return this.parent.get(node);
		
		//path compression기법을 사용하지 않고, 파라미터로 받은 노드의 루트노드를 반환해주는 이것만 생각한다면,
		//if(parent.get(node) != node)
		// return find(parent.get(node));
	}
	
	//nodeV와 nodeU를 합쳐라 라는 메서드 = UNION
	//union메서드를 호출하기 전에, nodeV와 nodeU를 연결할경우 + 사이클이 안생길때만, union메서드를 호출하게된다고 전제를 하겠음!
	public void Union(String nodeV, String nodeU) {
		String root1 = this.find(nodeV);
		String root2 = this.find(nodeU);
		
		//union-by-rank기법 
		if(this.rank.get(root1) > this.rank.get(root2)) {
			this.parent.put(root2, root1);
		} else { //root1의 랭크 < root2의 랭크 + root1의 랭크 == root2의 랭크
			this.parent.put(root1, root2);
			if(this.rank.get(root1) == this.rank.get(root2)) { //랭크가 서로 같은지 확인
				this.rank.put(root2, this.rank.get(root2) + 1);
			}
		}
		
	}
	
	//초기화, union-find메서드를 사용하기 위해, 맨 처음에는 n개의 원소를 개별적인 부분집합으로 만들어야함. 또한 rank는 모두 0!
	public void makeSet(String node) {
		this.parent.put(node, node); //개별적인 부분집합이라면, 각 노드의 루트노드는 곧 자기자신이겠지!
		this.rank.put(node, 0);
	}
	
	//노드들의 리스트인 vertices와 그래프 정보인 edges를 파라미터로 받음.
	public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges){
		ArrayList<Edge> mst = new ArrayList<Edge>();
		
		Edge currentEdge;
		
		//1. 초기화
		for(int i=0; i<vertices.size(); i++) {
			makeSet(vertices.get(i));
		}
		
		//2. 간선의 가중치 기반으로 정렬
		Collections.sort(edges);
		
		for(int i=0; i<edges.size(); i++) {
			currentEdge = edges.get(i); //간선이 가장 작은것부터 currentEdge에 담기게 됨.
			if(this.find(currentEdge.nodeV) != find(currentEdge.nodeU)) { //두 특정노드의 루트노드가 서로 다르다 = 사이클이 생기지 않는다면 -> 이때 합쳐라!
				this.Union(currentEdge.nodeV, currentEdge.nodeU);
				mst.add(currentEdge);
			}
		}
		
		return mst;
	}

}

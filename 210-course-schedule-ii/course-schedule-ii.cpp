class Solution {
public:
    vector<int> findOrder(int V, vector<vector<int>>& edges) {

        vector<int> inDegree(V,0);
        vector<vector<int>> adj(V);
        vector<int> ans;

        for(auto edg:edges){
            int u=edg[0];
            int v=edg[1];

            adj[v].push_back(u);
            inDegree[u]++;
        }


        queue<int> q;

        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
                q.push(i);
        }


        while(!q.empty()){

            int node=q.front();
            q.pop();

            ans.push_back(node);

            for(auto nbr:adj[node]){

                inDegree[nbr]--;

                if(inDegree[nbr]==0)
                    q.push(nbr);
            }
        }


        // cycle present
        if(ans.size()!=V)
            return {};

        return ans;
    }
};
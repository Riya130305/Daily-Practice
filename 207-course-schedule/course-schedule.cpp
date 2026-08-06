class Solution {
public:
    bool canFinish(int n, vector<vector<int>>& arr) {
        // kahn's algo
        vector<vector<int>> adj(n);
        vector<int> inDegree(n,0);

        for(auto edg: arr){
            int u=edg[0];
            int v=edg[1];
            inDegree[v]++;
            adj[u].push_back(v);
        }

        queue<int> q;

        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                q.push(i);
            }
        }
        
        while(!q.empty()){
            int node=q.front();
            q.pop();

            for(auto nbr: adj[node]){
                inDegree[nbr]--;
                if(inDegree[nbr]==0){
                    q.push(nbr);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(inDegree[i]!=0)
            return false;
        }
        return true;
    }
};
class Solution {
public:
    void dfs(vector<vector<int>>& adj, int node, vector<bool> &visited){
        visited[node]=true;
        for(int nbr: adj[node]){
            if(!visited[nbr]){
                dfs(adj,nbr,visited);
            }
        }
    }    
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        
        int n=isConnected.size();
        vector<int> ans;
        vector<vector<int>> adj(n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj[i].push_back(j);
                }
            }
        }

        
        vector<bool> visited(n,false);
        int count=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(adj,i,visited);
            }
        }
        return count;

    }
};
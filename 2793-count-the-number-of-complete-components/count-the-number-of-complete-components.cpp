class Solution {
    int ans=0;
    public:
    void dfs(vector<vector<int>>& adj, int node, vector<bool> &visited,int &E, int &V){
        V++;
        visited[node]=true;
        //E+=adj[node].size();
        for(int nbr: adj[node]){
           E++;
            if(!visited[nbr]){
                dfs(adj,nbr,visited,E,V);
            }
        }
        // cout << " V " << V << endl;
        // cout << " E " << E << endl;
        // // if((V*(V-1))/2==E/2) ans=ans+1;
        // cout << " ans " << ans <<endl;
    }  
public:
    int countCompleteComponents(int m, vector<vector<int>>& edges) {

        int n=edges.size();
        vector<vector<int>> adj(m);

       for(auto edg:edges){
            int v=edg[0];
            int u=edg[1];

            adj[u].push_back(v);
            adj[v].push_back(u);
       } 
       

        vector<bool> visited(m,false);
        
        for(int i=0;i<m;i++){
            if(!visited[i]){
                int E=0;
                int V=0;

                dfs(adj,i,visited,E,V);

                E = E/2;

                if(E == (V*(V-1))/2) {
                    ans++;
                }
            }
        }
        return ans;

    }
};
//T.C -> 
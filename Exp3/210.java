class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int [] degree=new int[numCourses];
        for(int[] i: prerequisites){
            int u=i[0];
            int v =i[1];

            adj.get(v).add(u);
            degree[u]++;
        }

        Queue<Integer>q=new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(degree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> ans =new ArrayList<>();
        while(!q.isEmpty()){
            int parent =q.poll();
            ans.add(parent);
            for(int i=0; i<adj.get(parent).size(); i++){
                int child = adj.get(parent).get(i);
                degree[child]--;
                if(degree[child]==0){
                    q.offer(child);
                }
            }
        }

        if (ans.size() != numCourses) return new int[]{};

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}

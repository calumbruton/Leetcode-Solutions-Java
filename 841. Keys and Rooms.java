class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int N = rooms.size();
        //Use a data structure to keep track that all N rooms have been entered - i.e key found - 0 for no 1 for yes
        int [] visited = new int[N];
        visited[0] = 1;
        
        //BFS
        Queue <Integer> queue = new ArrayDeque<>();
            
        //For j in rooms[0] add room to queue
        for (int i=0; i<rooms.get(0).size(); i++){
            queue.add(rooms.get(0).get(i));
        }
      
        //while the queue is not empty - add rooms and mark them as visited if not already marked
        while (!queue.isEmpty()){
            int curr = queue.remove();
            visited[curr] = 1;
            
            //add the rooms that the current room has keys for to the queue
            for (int i=0; i<rooms.get(curr).size(); i++){
                //If the room has not yet been visited and is not currently in the queue add it to the queue
                int roomNum = rooms.get(curr).get(i);
                if ((visited[roomNum] == 0))
                    queue.add(roomNum); 
            }
        }
        
        //After the queue has been emptied check that all rooms have been entered, if not return false
        for (int i=0; i<N; i++){
            if (visited[i] != 1)
                return false;
        }
        
        return true;
    }
}
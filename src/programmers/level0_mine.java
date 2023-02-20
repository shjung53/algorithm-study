package programmers;

class Solution {
    public int solution(int[][] board) {
        int[] dx = new int[] {-1,0,1};
        int[] dy = new int[] {-1,0,1};
        int answer = 0;

        int n = board.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==1){
                    for(int k=0; k<3; k++){
                        for(int l=0; l<3; l++){
                            if(i+dx[k]<0 || i+dx[k]>=n || j+dy[l]<0 || j+dy[l]>=n){
                                continue;
                            }
                            if(board[i+dx[k]][j+dy[l]]==0){
                                board[i+dx[k]][j+dy[l]]=2;
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==0){
                    answer++;
                }
            }
        }


        return answer;
    }
}

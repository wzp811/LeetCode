package QuestOfTheDay;

public class ImagesSmoother {
    public int[][] imagesSmoother(int[][] img) {
        int[][] helper = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int[][] res = new int[img.length][img[0].length];
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[0].length;j++){
                int sum = img[i][j];
                int cnt = 1;
                for(int p=0;p<helper.length;p++){
                    if(i+helper[p][0]>=0&&i+helper[p][0]<img.length&&j+helper[p][1]>=0&&j+helper[p][1]<img[0].length){
                        cnt++;
                        sum += img[i+helper[p][0]][j+helper[p][1]];
                    }
                }
                res[i][j] = sum/cnt;
            }
        }
        return res;
    }
}

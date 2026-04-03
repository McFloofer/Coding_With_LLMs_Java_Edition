public class container_with_most_water {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max_area=0;
        while(left<right) {
            max_area=Math.max(max_area, Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]) {
                left+=1;
            } else {
                right-=1;
            }
        }
        return max_area;
    }
}
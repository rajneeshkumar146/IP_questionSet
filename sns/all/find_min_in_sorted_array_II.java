package pep_sns;

public class find_min_in_sorted_array_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 3, 4, 4, 1};
		// {0, 1, 1, 1, 0}; {1, 0, 0, 0, 1}; {-1, -1, -1, -1};
		System.out.println(findMin(nums));
	}
	public static int findMin(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums[0] < nums[nums.length - 1])
            return nums[0];
        for(int i = 0; i <nums.length -1 ; i++){
            if(nums[i + 1] < nums[i])
                return nums[i + 1];
            if(i == nums.length - 2 && nums[i] == nums[i + 1])
                return nums[i + 1];
        }

        return -1;
    }

}
//BINARY SEARCH -> N 
/* public int findMin(int[] nums) {
if(nums.length == 0)
return 0;
if(nums.length == 1){
return nums[0];
}
if (nums.length == 2) {
return nums[0] <= nums[1] ? nums[0] : nums[1];
}
int start = 0;
int end = nums.length - 1;

return nums[bsearch(nums, start, end)];

}

public static int bsearch(int[] nums, int start, int end){
if (end - start + 1 <= 2) {
return nums[start] <= nums[end] ? start : end;
}

int mid = (start + end) / 2;

if(mid==end)
return mid;
if(mid==start)
return start+1;

if(nums[start] == nums[mid] && nums[end] == nums[mid]){
int p1 = bsearch(nums, start, mid);
int p2 = bsearch(nums, mid+1, end);
return nums[p1] < nums[p2] ? p1 : p2;
}
if (nums[mid - 1] <= nums[mid] && nums[mid] > nums[mid + 1]) {
return mid + 1;
}
if (nums[mid - 1] > nums[mid] && nums[mid] <= nums[mid + 1]) {
return mid;
}
if (nums[start] <= nums[mid] && nums[end] < nums[mid]) {
return bsearch(nums, mid+1, end);
} else if (nums[start] > nums[mid] && nums[end]>=nums[mid]){
return bsearch(nums, start, mid-1);
}else{
return start;
}
}*/
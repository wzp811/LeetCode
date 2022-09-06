package Period.Hot100;

public class No287_FindDuplicate {
    // 题解二分法
    public int findDuplicate1(int[] nums){
        int n = nums.length-1;
        int l = 1, r = n;
        int mid = l+((r-l)>>1);
        while(l<r){
            mid = l+((r-l)>>1);
            int cnt = 0;
            for(int i=0;i<=n;i++) if(nums[i]<=mid) cnt++;
            if(cnt>mid) r = mid;
            else l = mid+1;
        }
        return mid;
    }
    // 题解按位计算
    // 例如 1，3，4，2，2
    // 二进制就是 001  011  100  010  010
    // 对于每一位上面，统计[1,n]和nums[]里面所有数该位上为1的数目，结果如下
    //         [1,n]     nums[]     res
    // 第0位：    2         2         0
    // 第1位：    2         3         1
    // 第2位：    1         1         0
    // 结果就是010也就是2
    public int findDuplicate2(int[] nums){
        int x, y;
        int res = 0;
        int n = nums.length-1;
        int bit = 1;
        while(bit<=n){
            x = 0;
            y = 0;
            for(int i=0;i<=n;i++){
                if((i&bit)!=0) x++;
                if((nums[i]&bit)!=0) y++;
            }
            if(y>x) res = res|bit;
            bit = bit<<1;
        }
        return res;
    }

    // 题解快慢指针 每一个nums[i]都能指向一个位置
    public int findDuplicate(int[] nums){
        // 相当于同时从头节点开始出发，然后进行一次移动
        int slow = nums[0];
        int fast = nums[nums[0]];
        // int slow = 0;
        // int fast = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        // 找到环后，fast不动，slow回到头节点，接下来每次走一步，相遇就是环入口
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

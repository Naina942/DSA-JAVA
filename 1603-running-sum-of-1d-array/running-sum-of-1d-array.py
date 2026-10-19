class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        s=0
        r=[]
        for i in range(len(nums)):
            s+=nums[i]
            r.append(s)
        return r
        
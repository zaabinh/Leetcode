class Solution(object):
    def twoSum(self, nums, target):
        d = {}
        for i, num in enumerate(nums):
            j = d.get(target - num)
            if j is not None:
                return [j, i]
            d[num] = i
        return []

s = Solution()
nums = [2,7,11,15]
target = 9
print(s.twoSum(nums, target))
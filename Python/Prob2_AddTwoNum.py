# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        tmp = ListNode(0)
        point = tmp
        carry = 0
        while l1 or l2 or carry:
            dg1 = l1.val if l1 else 0
            dg2 = l2.val if l2 else 0

            sum = dg1 + dg2 + carry
            dg = sum % 10
            carry = sum // 10

            point.next = ListNode(dg)
            point = point.next
            
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return tmp.next
    
def list_to_linkedlist(lst):
    dummy = ListNode()
    cur = dummy
    for x in lst:
        cur.next = ListNode(x)
        cur = cur.next
    return dummy.next

def linkedlist_to_list(node):
    result = []
    while node:
        result.append(node.val)
        node = node.next
    return result

s = Solution()

l1 = list_to_linkedlist([2, 4, 3])
l2 = list_to_linkedlist([5, 6, 4])
print(linkedlist_to_list(s.addTwoNumbers(l1, l2))) 
        
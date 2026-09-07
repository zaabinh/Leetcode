// struct List {
//    ListNode *Head;
//    ListNode *Tail;
// };
//
// void CreateList(List &I)
// {
//     I.Head = NULL;
//     I.Tail = NULL;
// }
// void Out(List I)
//{
//    ListNode *p = I.Head;
//    while(p != NULL)
//    {
//        cout << p->val;
//        p = p -> next;
//    }
//}
// void AddTail(List &I, ListNode *p)
//{
//    if(I.Head == NULL)
//    {
//        I.Head = p;
//        I.Tail = I.Head;
//    }
//    else
//    {
//        I.Tail -> next = p;
//        I.Tail = p;
//    }
//}
#include<bits/stdc++.h>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
 };

ListNode *Read()
{
    int n;
    ListNode *tmp = new ListNode(0);
    ListNode *point = tmp;
    while(1)
    {
        cin >> n;
        if(n == 0) break;
        ListNode *q = new ListNode(n);
        point -> next = q;
        point = point -> next;
    }
    ListNode *inp = tmp -> next;
    delete tmp;
    return inp;
}

void Out(ListNode *p)
{
    while(p != nullptr)
    {
        cout << p -> val;
        p = p -> next;
    }
    cout << endl;
}

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *tmp = new ListNode(0);
        ListNode *point = tmp;
        int carry = 0;
        while(l1 != nullptr || l2 != nullptr || carry > 0)
        {
            int dg1 = (l1 != nullptr) ? l1 -> val : 0;
            int dg2 = (l2 != nullptr) ? l2 -> val : 0;

            int s = dg1 + dg2 + carry;
            int dg = s % 10;
            carry = s / 10;
            ListNode *digit = new ListNode(dg);
            point -> next = digit;
            point = point -> next;
            l1 = (l1 != nullptr) ? l1 -> next : nullptr;
            l2 = (l2 != nullptr) ? l2 -> next : nullptr;
        }
        ListNode *result = tmp -> next;
        delete tmp;
        return result;
    }
};

int main()
{
    ListNode *a, *b;
    a = Read();
    b = Read();
    Solution Solve;
    ListNode *tmp = Solve.addTwoNumbers(a, b);
    Out(a);
    Out(b);
    Out(tmp);

}

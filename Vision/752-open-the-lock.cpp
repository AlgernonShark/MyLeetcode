class Solution {
public:
    struct node
    {
        string lock;
        int depth;
    };
    unsigned int res;
    unordered_set<string> deadset;
    queue<node> allLocks;
    int visit[10][10][10][10];  //其实可以用unordered_set<string>来存已经访问过的密码

    int cToI(char c)
    {
        return (c - '0' + 10)%10;
    }

    //bfs模板可以再优化一下
    void bfs()
    {
        while(!allLocks.empty())
        {
            auto first = allLocks.front();
            auto lock = first.lock;
            allLocks.pop(); 
            if(visit[cToI(lock[0])][cToI(lock[1])][cToI(lock[2])][cToI(lock[3])])
                continue;
            else
                visit[cToI(lock[0])][cToI(lock[1])][cToI(lock[2])][cToI(lock[3])] = 1;
            if(deadset.find(lock) != deadset.end())
                continue;
            if(lock == "0000")
            {
                if(first.depth < res)
                    res = first.depth;
                break;
            }
            helper(lock,first.depth + 1);
        }
    }

    void helper(string lock,int output)
    {
        for(int i = 0;i <4;i++)
        {
            string t1 = lock,t2 = lock; 
            t1[i] = cToI(t1[i] + 1) + '0';
            t2[i] = cToI(t2[i] - 1) + '0';
            allLocks.push(node{t1,output});
            allLocks.push(node{t2,output});
        }
    }

    int openLock(vector<string>& deadends, string target) {
        res = -1;
        memset(visit,0,sizeof(int)*10*10*10*10);
        for(auto &str : deadends)
            deadset.insert(str);
        if(deadset.find("0000") != deadset.end())
            return -1;
        allLocks.push(node{target,0});
        bfs();
        return res;
    }
};
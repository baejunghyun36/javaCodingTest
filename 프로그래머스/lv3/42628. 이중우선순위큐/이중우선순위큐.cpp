#include <string>
#include <vector>
#include <queue>
#include <iostream>
#include <sstream>
using namespace std;
vector<int> solution(vector<string> operations) {
    vector<int> answer;
    priority_queue<int> maxQ; 
    priority_queue<int, vector<int>, greater<int>> minQ; 
    int maxQueueCnt=0; 
    int minQueueCnt=0; 
    int totalCnt =0; 
    for(int i=0; i<operations.size(); i++){
        stringstream ss(operations[i]); 
        string temp; 
        ss>>temp; 
        if(temp=="I"){
            ss>>temp; 
            totalCnt++; 
            minQ.push(stoi(temp)); 
            maxQ.push(stoi(temp)); 
        }
        else if(temp=="D"&&totalCnt>0){
            ss>>temp; 
            if(temp=="-1"){//작은값 팝
                minQ.pop(); 
                totalCnt--; 
            }
            else {
                maxQ.pop(); 
                totalCnt--; 
            }
            if(totalCnt==0){
                while(!minQ.empty())minQ.pop(); 
                while(!maxQ.empty())maxQ.pop(); 
                continue; 
            }
        }
    }
    if(totalCnt==0){
        answer.push_back(0); 
        answer.push_back(0); 
    }
    else{
        answer.push_back(maxQ.top()); 
        answer.push_back(minQ.top());
    }
    return answer;
}
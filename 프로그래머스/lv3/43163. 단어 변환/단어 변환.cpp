#include <string>
#include <vector>
#include <algorithm> 
#include <iostream>
int v[50]; 
using namespace std;
vector <string> w; 
string t; 
int result = 987654321; 
void dfs(string s,  int cnt ){
    if(s==t){
        result = min(result, cnt);
        return; 
    }         
    for(int i=0; i<w.size(); i++){
        if(v[i])continue;
        int check =0;  
        for(int j =0; j<s.size(); j++){
            if(s[j]==w[i][j])check++;             
        }
        if(check==s.size()-1){        
            v[i]=1;           
            dfs(w[i], cnt+1);            
            v[i]=0; 
        }
    }    
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0;
    w = words; 
    t = target; 
    dfs(begin, 0); 
    if(result==987654321)return 0; 
    else return result;
}
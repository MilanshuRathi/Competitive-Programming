#include<bits/stdc++.h>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin>>t;
    while(t--){
        string s,p;
        cin>>s>>p;
        int i=0;
        for(i=0;i<p.size();i++){
            auto it = find(s.begin(), s.end(),p[i]);
            if (it != s.end())
                s.erase(it);    
        }
        sort(s.begin(),s.end());
        string newString(s.begin(),s.end());
        newString.push_back(p[0]);
        sort(newString.begin(),newString.end(),greater<char>());
        size_t index=newString.find(p[0]);
        size_t extraIndex=s.find(p[0]);
        // cout<<s<<endl;
        // cout<<s.substr(0,4)<<endl;
        if(extraIndex==string::npos){
         cout<<s.substr(0,newString.size()-index-1)+p+s.substr(newString.size()-index-1)<<endl;   
        }
        else{
            // cout<<s<<endl;
            string sample=s.substr(0,extraIndex)+p+s.substr(extraIndex),another=s.substr(0,newString.size()-index-1)+p+s.substr(newString.size()-index-1);
            // cout<<extraIndex<<endl;
            if(sample<another)
                cout<<sample<<endl;
            else
                cout<<another<<endl;
        }
    }
}
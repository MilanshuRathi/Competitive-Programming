let tc=10;
while(tc!=0){
    const n=Math.floor(Math.random()*100+1),arr='abcdefghijklmnopqrstuvwzyz';
    let str1='',str2='';
    for(let i=0;i<n;i++){
        str1+=arr[Math.floor(Math.random()*arr.length)];
    }
    const length=Math.floor(Math.random()*n+1);
    for(let i=0;i<length;i++){
        str2+=str1[Math.floor(Math.random()*n)];
    }
    console.log(str1);
    console.log(str2);
    tc--;
}
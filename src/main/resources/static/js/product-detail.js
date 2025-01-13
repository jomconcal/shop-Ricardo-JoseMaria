const btn=document.getElementById("close-dialog");
btn.addEventListener("click",()=>{
    window.parent.postMessage({message:"close"});
})
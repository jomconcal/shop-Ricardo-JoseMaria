const btn=document.getElementById("close-dialog");
btn.addEventListener("click",()=>{
    window.parent.postMessage({message:"close"});
})

function setRating(){
    const filledStars=document.getElementById("filled-stars")
    const rating=filledStars.getAttribute("rating")
    const width=rating/5*100;
    filledStars.style.width=`${width}%`
}

setRating()
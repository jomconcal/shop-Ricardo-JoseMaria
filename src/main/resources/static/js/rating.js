function setRating(){
    const filledStars=Array.from(document.getElementsByClassName("filled-stars"))
    if(filledStars){

       filledStars.forEach(filledStar=>{
           const rating=filledStar.getAttribute("rating")
           const width=rating/5*100;
           filledStar.style.width=`${width}%`
       })
    }
}

setRating()
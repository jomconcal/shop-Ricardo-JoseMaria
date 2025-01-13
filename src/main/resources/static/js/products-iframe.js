const products = Array.from(document.querySelectorAll(".product-link"));
const dialog = document.getElementById("product-dialog");
const iFrame = document.getElementById("product-iframe");
products.forEach(product => {
    product.addEventListener("click", (event) => {
        const productId = event.currentTarget.getAttribute("data-iframe-src");
        const url=iFrame.getAttribute("url");
        iFrame.src=`${url}?productId=${productId}`
        dialog.showModal();
        dialog.classList.remove("hide")
        dialog.classList.add('show');

    })
})

window.addEventListener("message",(event)=>{
    if(event.data.message==="close") {
        dialog.classList.add("hide")
        dialog.classList.remove("show")
        setTimeout(()=>{
            dialog.close();
        },1000)

    }
})
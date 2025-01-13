const products = Array.from(document.querySelectorAll(".product-link"));
const dialog = document.getElementById("product-dialog");
const closeBtn = document.getElementById("close-dialog");
const iFrame = document.getElementById("product-iframe");
products.forEach(product => {
    product.addEventListener("click", (event) => {
        const productId = event.currentTarget.getAttribute("data-iframe-src");
        const url=iFrame.getAttribute("url");
        iFrame.src=`${url}?productId=${productId}`
        dialog.showModal();
    })
})

closeBtn.addEventListener("click", () => {
    dialog.close();
})
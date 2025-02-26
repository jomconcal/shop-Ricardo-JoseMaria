const addButtons = document.getElementsByClassName("btnAdd");

Array.from(addButtons).forEach(button => {

    button.addEventListener("click", () => {
        console.log("appRootPath: "+ appRootPath)
        fetch(appRootPath + "api/cart", {
            method: "POST",
            body: JSON.stringify({
                "productId": button.getAttribute("data-productId"),
                "quantity": 1
            }),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        }).then(response => {
            let title;
            let text;
            let icon;
            if (response.status === 200) {
                title = "200"
                text = "Product added"
                icon = "success"
            } else if (response.status === 409) {
                title = "409"
                text = "Not enough Stock"
                icon = "error"
            }
            Swal.fire({
                title: title,
                text: text,
                icon: icon
            });
        }).catch(err => {
            console.log(err)
        })
    })
})
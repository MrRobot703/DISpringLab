window.onload = function() {
   Item.getItemsInCart().then(items => items.forEach(addToCartView));
}


let cartDropDown = document.getElementById('cartDropDown');
let summaryLine = document.getElementById('summaryLine');
let counter = 0;
cartIcon.onclick = function openCart(){
        if (cartDropDown.style.display == "block"){
            cartDropDown.style.display = "none";
        }
        else{
            cartDropDown.style.display = "block";
        }
}

function addItemToCart(button) {
    let tr = button.parentNode.parentNode;
    let id = tr.id;
    let item = items.filter(item => item.id == id)[0];
    Item.addItemToCart(item);
    addToCartView(item);
}


function addToCartView(item) {
        let cartElementDiv = document.createElement('div');
        cartElementDiv.classList.add("cartElement");

        let circle = document.getElementById('circle');

        /*let img = document.createElement('img');
        img.classList.add("productPicture");
        img.setAttribute("src", item.picture);*/

        let nameH4 = document.createElement('h4');
        nameH4.innerHTML = item.name;

        let descriptionSpan = document.createElement('span');
        descriptionSpan.innerHTML = item.description;

        let priceDiv = document.createElement('div');
        priceDiv.classList.add("price");
        priceDiv.innerHTML = item.price + " $";

        let closePicture = "https://cdn0.iconfinder.com/data/icons/navigation-set-arrows-part-one/32/Close-128.png"
        let closeImg = document.createElement('img');
        closeImg.id = item.id;
        closeImg.classList.add("close");
        closeImg.setAttribute("src", closePicture);
        closeImg.onclick = function() {
             let parent = closeImg.parentNode.parentNode;
             let child = closeImg.parentNode;
             parent.removeChild(child)
             Item.removeItemFromCart(item);
             counter--;
             circle.innerHTML = counter;
             totalSum()
        }

        cartDropDown.insertBefore(cartElementDiv, summaryLine);
        //div.appendChild(img);
        cartElementDiv.appendChild(nameH4);
        cartElementDiv.appendChild(descriptionSpan);
        cartElementDiv.appendChild(priceDiv);
        cartElementDiv.appendChild(closeImg);

        counter++;
        circle.innerHTML = counter;

        function totalSum(){
            let summ = 0
            let elementsPrice = document.getElementsByClassName('price');
            for(i = 0; i < elementsPrice.length; i++){
                summ += parseFloat(elementsPrice[i].innerHTML);
                totalPrice.innerHTML = summ + " $";
            }
            if(elementsPrice.length == 0){
                summ = 0;
                totalPrice.innerHTML = summ + " $";
            }
        }
        totalSum()
}
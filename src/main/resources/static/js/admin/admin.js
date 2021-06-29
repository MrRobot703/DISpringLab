let productModels = []
let csrfToken = {}

window.onload = function () {
    for (let link of document.querySelectorAll(".app-sidebar > ul.app-sidebar-menu > li > a"))
        link.addEventListener("click", switchActive);
    document.querySelector('a[href="#dashboard"]').click();
    get("/csrfToken").then(token => csrfToken = token);
}

function switchActive(event) {
    event.preventDefault();
    document.querySelectorAll(".active").forEach(e => e.classList.remove("active"));
    let name = event.currentTarget.getAttribute("href").substr(1);
    let section = document.querySelector(".section[data-view-name=" + name + "]");
    event.currentTarget.parentElement.classList.add("active")
    if (!section)
        document.querySelector(".section[data-view-name=not_found]").classList.add("active")
    else
        section.classList.add("active")
}

function deleteProduct(button) {
    let itemView = button.parentNode.parentNode;
    let name = itemView.id;
    let productToDelete = productModels.filter(product => product.name == name)[0];
    Item.deleteItemByNamePromise(productToDelete).then(() => itemView.parentNode.removeChild(itemView));
}

function deleteAllProducts() {

}

function addNewProduct() {
    let quantity = Number(document.getElementById("quantity").value);
    productModels = Item.getMockItems(quantity);
    for (let item of productModels) {
        Item.addItemPromise(item);
    }
    createViewFor(productModels);
    return false;
}

function loadItems() {
    clearView();
    Item.getAllItemsPromise().then(products => {
        productModels = products;
        createViewFor(products);
        toggleButtons("invisible", "visible");
    });
}

function clearView() {
    elementProducs = document.querySelector(".products");
    while (elementProducs.firstChild) {
        elementProducs.removeChild(elementProducs.lastChild);
    }
    toggleButtons("visible", "invisible");
}

function toggleButtons(className1, className2) {
    document.querySelectorAll(".button-panel > ." + className1).forEach(button => {
        button.classList.remove(className1);
        button.classList.add(className2);
    });
}

function createViewFor(products) {
    products.map(item => createItemViewNodesFor(item).item(0))
        .forEach(itemView => document
            .querySelector(".products")
            .appendChild(itemView)
        );
}

function createItemViewNodesFor(item) {
    let htmlTemplate = '<div class="product"><div class="button-panel"><button onclick="editProduct()">Edit</button><button onclick="deleteProduct(this)">Delete Product</button></div><div class="product-image"><img src=""></div><div class="product-info"><h5 class="name">Winter Jacket</h5><h6 class="price">$99.99</h6><p class="description">Description</p></div></div>';
    let viewNodes = createNodesFromHtml(htmlTemplate);
    for (let view of viewNodes) {
        view.setAttribute("id", item.name);
        view.querySelector(".product-image img").setAttribute("src", "/resources/images/products/apple.png");
        view.querySelector(".name").innerHTML = item.name;
        view.querySelector(".price").innerHTML = item.price;
        view.querySelector(".description").innerHTML = item.description;
    }
    return viewNodes;
}

function createElement(elementName, className, attributes) {
    let element = document.createElement(elementName);
    if (className)
        element.classList.add(className);
    if (attributes)
        attributes.forEach(att => element.setAttribute(...att));
    return element;
}

function createNodesFromHtml(htmlString) {
    let div = document.createElement("div");
    div.innerHTML = htmlString.trim();
    if (div.hasChildNodes()) {
        return div.childNodes;
    }
}
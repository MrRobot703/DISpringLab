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
    let name = button.parentNode.parentNode.id;
    let productToDelete = productModels.filter(product => product.name = name)[0];
    Item.deleteItemByNamePromise(productToDelete);
}

function addNewProduct() {
    items = Item.getMockItems(5);
    for (let item of items) {
        Item.addItemPromise(item);
    }
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
    document.querySelectorAll("button." + className1).forEach(button => {
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

function post(url, object) {
    return fetch(url, {
                           method: 'POST',
                           headers: {
                               'Content-Type': 'application/json;charset=utf-8',
                               [csrfToken.headerName]: [csrfToken.token]
                           },
                           body: JSON.stringify(object)
                       }).then(response => handle(response));
}

function get(url) {
     return fetch(url, {
             method: 'GET',
             headers: {
                 'Accept': 'application/json;charset=utf-8'
             }
         }).then(responce => responce.json());
}

function handle(text) {
    console.log(text);
}

class Item {
    constructor(id, name, price, description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    static getMockItems(n) {
        let items = []
        for (let i = 1; i < n + 1; i++)
            items.push(new this(i, "name" + i, i + 0.99, "discription" + i));
        return items;
    }

    static getAllItemsPromise() {
        return get("/getAllItems");
    }

    static addItemPromise(item) {
        return post("/saveItem", item);
    }

    static deleteItemByNamePromise(item) {
        return post("/deleteItem", item);
    }

    static editItemPromise(item) {
        return post("/updateItem", item);
    }
}

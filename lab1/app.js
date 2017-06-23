// single state store
class Store {
    // these are the key name you can use in Store
    const CART_KEY = 'CART';
    const QUEUE_KEY = 'QUEUE';
    const FOODS_KEY = 'FOODS';

      constructor (storage) {
        this.storage = storage; // assuming local storage will be passed in as storage
        // these are the key name you can use in Store
        this.CART_KEY = 'CART';
        this.QUEUE_KEY = 'QUEUE';
        this.FOODS_KEY = 'FOODS';
    }

    // you can get item by store.cartItems
    get cartItems () {
        return JSON.parse(this.storage.getItem(this.CART_KEY));
    }

    // to call setter, simply "assign" like store.cartItems = something
    set cartItems (cartItems) {
        this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
    }

    get queue () {
        return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
    }

    set queue (queue) {
        this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
    }

    get foods () {
        return JSON.parse(this.storage.getItem(this.FOODS_KEY));
    }

    set foods (foods) {
		  this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
    }
}

class Cart {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
		this.items = this.store.cartItems;
        init();
    }

    init () {
        // Render a list of items under root element
       this.render();
        // TODO: attach all necessary events
    }

    destroy () {
        // TODO: remove all the events attached from init
    }

    // remove an item from shopping cart
    removeItem (item) {
		
		
        // TODO: logic to remove an item from cart
        // call render method when the item is removed to update view
        this.render();
    }

    placeOrder () {
        // add item to statuses in store as status "in progress"
    }

    // render a list of item under root element
    render () {
		let tbody = this.root.querySelector('tbody');
		//tbody.innerHTML = <tr>
			//<td></td>
			//<td></td>
			//<td></td>
		//</tr>
    }
}

class CheckoutButton {
    constructor(root, store) {
        this.root = root;
        this.store = store;
		this.onClick = () => this.addItemToCart;
        this.init();
    }

    init () {
		this.root.addEventListener('click', this.onClick);
    }

    destroy () {
		this.root.removeEventListener('click', this.onClick);

    }

    addItemToCart () {
		
		let cartItems = this.store.cartItems || [];
        // hint: you can use `dataset` to access data attributes
        // See passing data from HTML to JavaScript from course note
		cartItems.push({dataset.name});
    }
}

class StatusTable {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        init();
    }

    init () {
        // attach click event listener to table header row on each column
        render();
    }

    destroy () {
        // remove all the events attached from init
    }

    sort (columnName) {
        // after sorting the array of statuses, re render item to update view
        render();
    }

    // render rows of items under table using root.innerHTML
    render () {
		this.root.innerHTML = <ul> ${} </ul>
	
    }
}

// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
    // use querySelector to find the table element (preferably by id selector)
    let statusTable = document.querySelector('');
    // use querySelector to find the cart element (preferably by id selector)
    let cart = document.querySelector('');
    let checkoutButtons = document.querySelectorAll('');

    let store = new Store(window.localStorage);
    if (table) {
        new StatusTable(table, store);
    }
    if (cart) {
        new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        new CheckoutButton(checkoutButtons, store);
    }
});
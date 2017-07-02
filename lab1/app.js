// single state store
class Store {
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
        this.root = root; //table elements
        this.store = store;
		this.items = this.store.cartItems;
        this.init();
    }

    init () {
        // Render a list of items under root element
		this.render();
		this.removeItem();
        // TODO: attach all necessary events
    }

    destroy () {
        // TODO: remove all the events attached from init
    }

    // remove an item from shopping cart
    removeItem () {
		let deleteButtons = this.root.querySelectorAll('.delete-button');
		 
		 for (var i = 0; i < deleteButtons.length; i ++) {
				let deleteBtn = deleteButtons[i];
        			deleteBtn.addEventListener('click', () => {
				//	debugger;
				// splice takes two arguments first being the index, second being
        		// the number of items removing
				console.log(this.items[0]);
        		this.items.splice(0, 1);
				alert('You are deleting');
			});
			
        }
	
		
        // TODO: logic to remove an item from cart
        // call render method when the item is removed to update view
        this.render();
    }

    placeOrder () {
        // add item to statuses in store as status "in progress"
		//checkout button 
		let placeOrderBtn = this.root.querySelector('.checkoout');
		console.log(placeOrderBtn);
		placeOrderBtn.addEventListener('click', () => {
			
			
		})
		
		
    }

    // render a list of item under root element
    render () {
		console.log(this.store.cartItems);
        let tbody = this.root.querySelector('tbody');
        // using innerHTML to render a list of table row item under tbody
        tbody.innerHTML = this.renderListAsHTML(this.items)
       
  }
	
	
    renderListAsHTML(list) {
		// replace with the for loop
		//let result = '<tr><td>Name</td><td>Price</td><td><button class="delete-button" data-id="0">Delete</button></td></tr>';
		//console.log(result);
		//return result;
		
		let result = " ";
		for(var i = 0; i<list.length; i++){
			result += "<tr><td>"+ list[i].name + "</td><td> " + list[i].price + '</td><td><button class="delete-button" data-id="0">Delete</button></td></tr>';
		}
		return result;
		
		
		
	
    }
   
}

class CheckoutButton {
    constructor(root, store) {
        this.root = root; //reference to button
        this.store = store;
        this.onClick = () => this.addItemToCart();
        this.init();
    }
	
     init () {
        this.root.addEventListener('click', this.onClick);
    }

    destroy () {
    }

	
	addItemToCart () {
        // hint: you can use `dataset` to access data attributes
        // See passing data from HTML to JavaScript from course note
        let cartItems = this.store.cartItems || [];
		
		  console.log(this.root.dataset);
		cartItems.push({ 
					name: this.root.dataset.name,
					price: this.root.dataset.price
		});
		console.log(cartItems);
		
		this.store.cartItems = cartItems;
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
		//this.root.innerHTML = <ul> ${} </ul>
	
    }
}

class Inventory {
    constructor(root, store) {
        this.root = root;
        this.store = store;
		this.foods = this.store.foods;
        this.init();
    }

    init () {
        this.render();
        // TODO: attach event listeners like click to remove items after rendering
    }

    destroy () {
        // TODO: remove event listeners added from the init above
    }

    removeItem (itemName) {
        // TODO: function to remove item given item name from store
		
		
    }

    render () {
        // using innerHTML to render inventory listing
		//let inventoryTable = this.root.querySelector("tbody");
		//console.log(this.foods);
		//inventoryTable.innerHTML = function(this.foods){
		//	let foods = this.foods;
		//	let result = " ";
		//	(var i = 0; i< foods.length; i++){
		//	result += "<tr><td>"+ food[i].date + "</td><td> " + food[i].name + '</td><td><button class="delete-button" data-id="0">Delete</button></td></tr>';
		//}
		//return result;
	//	}
    }
}

class Menu {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init () {
        this.render();
    }

    render () {
        // TODO: render a list of food menu from store using innerHTML
		
//		this.store.foods, should support/replace menu

		console.log(this.store.foods);
		//let result = " ";
		//	for(var i = 0; i<list.length; i++){
		//		result += "<tr><td>"+ list[i].name + "</td><td> " + list[i].price + '</td><td><button class="delete-button" data-id="0">Delete</button></td></tr>';
		//	}
		//return result;
//    }
	}
}

class CreateFood {
    constructor(root, store) {
        this.root = root; // root should be the container of the form itself
        this.store = store;
        this.init();
    }

    init () {
        // attach click event to create button
    }

    createFood () {
        // will need to do querySelector to find out every single form element
        // to get their values before creating a new food
        // after creating a new food item, add it to store
		
		 let foods = this.store.foods || [];
		 
		 let foodItem = this.root.querySelector('.newFoods');
		
		console.log(foodItem);
		//  console.log(foods);
		//foods.push({ 
			//		name: foodItem.name,
				//	img: foodItem.image,
				//description: foodItem.description,
						// ingredients: this.store.ingredient ||[]
		//});
		console.log(foods);
		
		this.store.foods = foods;
		//take name, image, description and add to foods
    }
}

// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
	console.log('This is the starting point');
    // use querySelector to find the table element (preferably by id selector)
    // let statusTable = document.querySelector('');
    // // use querySelector to find the cart element (preferably by id selector)
    let cart = document.querySelector('.cart');
    let checkoutButtons = document.querySelectorAll('.checkoutBtn');
	let inventory = document.querySelector('.inventory');

    console.log(cart);
    console.log(checkoutButtons);

    let store = new Store(window.localStorage);
    // if (table) {
    //     new StatusTable(table, store);
    // }
	
	
    if (cart) {
        new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i ++) {
            new CheckoutButton(checkoutButtons[i], store);
        }
    }
	
	if(inventory){
		new Inventory(inventory, store);
	}
});

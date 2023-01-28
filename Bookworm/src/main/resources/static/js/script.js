window.addEventListener('load', function(e) {
	console.log("Page Loaded");
	init();
});


function init() {
	loadBooks();
	document.newBook.submit.addEventListener('click', createBook);
	
	
}


function loadBooks() {
	//AJAX
	
	let xhr = new XMLHttpRequest();
	xhr.open("GET", "api/books");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let books = JSON.parse(xhr.responseText);
				displayBooks(books);
			} else if( xhr.status === 404) {
				
			}
		} 
	};
	
	xhr.send();
}


function displayBooks(books) {
	//DOM
	let bookTable = document.getElementById("bookTable")
	bookTable.textContent="";
	let tableHead = document.createElement("thead");
	let headerRow = document.createElement("tr");
	let authorHeader = document.createElement("th");
	let titleHeader = document.createElement("th");
	titleHeader.textContent = "Title";
	authorHeader.textContent = "Author";
	headerRow.appendChild(titleHeader);
	headerRow.appendChild(authorHeader);
	
	
	tableHead.appendChild(headerRow);
	bookTable.appendChild(tableHead);
	
	
	
	let tableBody = document.createElement("tbody");
	bookTable.append(tableBody);
	for (let book of books) {
		let tr = document.createElement("tr");
		let tdTitle = document.createElement("td");
		let tdAuthor = document.createElement("td");
		let tdID = document.createElement("td");
		tdID.textContent = book.id;
		tdTitle.textContent = book.title;
		tdAuthor.textContent = book.author;
		
		tdID.style.display="none";
		tr.style.cursor="pointer";
		
		tr.appendChild(tdTitle);
		tr.appendChild(tdAuthor);
		tr.appendChild(tdID);
		tr.addEventListener('click', getBook);
		tableBody.appendChild(tr);
	}
}

function displayBook(book) {
	let div = document.getElementById("displayBook");
	div.textContent = "";
	let id = document.createElement("div");
	id.textContent = book.id;
	id.style.display="none";
	let title = document.createElement("h2");
	title.textContent = book.title;
	let author = document.createElement("h4");
	author.textContent = book.author;
	let synopsis = document.createElement("div");
	synopsis.textContent = book.synopsis;
	let img = document.createElement("img");
	img.src = book.coverArt;
	img.style.maxWidth = "400px";
	
	div.append(id);
	div.appendChild(title)
	div.appendChild(author);
	div.appendChild(synopsis);
	div.appendChild(img);
	
	let br = document.createElement("br");
	div.appendChild(br)
	
	
	let deleteButton = document.createElement("input");
	deleteButton.type="button";
	deleteButton.name="delete";
	deleteButton.value="Delete";
	deleteButton.addEventListener('click', deleteBookButton);
	div.appendChild(deleteButton);
	
	let edit = document.createElement("input");
	edit.type="button";
	edit.name="edit";
	edit.value="Edit";
	edit.addEventListener('click', generateEditForm);
	div.append(edit);
	
	
	
	
}

function getBook(e) {	
	let id = e.target.parentElement.lastElementChild.textContent;
	let xhr = new XMLHttpRequest();
	
	xhr.open("GET", "api/books/" + id);
	
	xhr.onreadystatechange = function() {
		if ( xhr.readyState === 4 ) {
			if (xhr.status === 200) {
				displayBook(JSON.parse(xhr.responseText));
			} else {
				console.log(xhr.status);
			}
		}
	};
	
	xhr.send();
}

function getBookSilent(id) {
	let xhr = new XMLHttpRequest();
	
	xhr.open("GET", "api/books/" + id);
	
	xhr.onreadystatechange = function() {
		if ( xhr.readyState === 4 ) {
			if (xhr.status === 200) {
				let book = JSON.parse(xhr.responseText);
				populateEditForm(book);
			} else {
				console.log(xhr.status);
			}
		}
	};
	
	xhr.send();
}

function createBook(e) {
	e.preventDefault();
	let book = {
		title: document.newBook.title.value,
		author: document.newBook.author.value,
		synopsis: document.newBook.synopsis.value,
		coverArt: document.newBook.imageUrl.value
	};
	
	
	let xhr = new XMLHttpRequest();
	
	xhr.open("POST", "api/books")
	
	xhr.setRequestHeader("Content-Type", "Application/JSON");
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				displayBook(JSON.parse(xhr.responseText));
				loadBooks();
			}
		}
	};
	
	xhr.send(JSON.stringify(book));
	
}

function generateEditForm() {
	let div = document.getElementById("displayBook");
	let id = div.firstElementChild.textContent;
	div.textContent = "";
	
	
	getBookSilent(id);
	
	let hiddenId = document.createElement("div");
	hiddenId.textContent = id;
	hiddenId.style.display="none";
	
	let editForm = document.createElement("form");
	let title = document.createElement("input");
	let author = document.createElement("input");
	let synopsis = document.createElement("textarea");
	let coverArt = document.createElement("input");
	let submit = document.createElement("input");
	
	
	
	editForm.name="editForm";
	title.type="text";
	title.name="title";
	author.type="text";
	author.name="author";
	synopsis.name = "synopsis";
	synopsis.cols="50";
	synopsis.rows="4";
	coverArt.type="text";
	coverArt.name="coverArt";
	submit.type="submit";
	submit.name="submit";
	submit.value="Submit";
	
	editForm.appendChild(hiddenId);
	
	editForm.appendChild(title);
	editForm.appendChild(author);
	editForm.appendChild(synopsis);
	editForm.appendChild(coverArt);
	editForm.appendChild(submit);
	div.appendChild(editForm);
	
	for (input of editForm) {
		let br = document.createElement("br");
		input.after(br);
	}
	
}

function populateEditForm(book) {
	
	let form = document.editForm;
	form.title.value=book.title;
	form.author.value=book.author;
	form.synopsis.value=book.synopsis;
	form.coverArt.value=book.coverArt;
	
	
	
	form.submit.addEventListener('click', updateBook);

	
}

function updateBook(e) {
	e.preventDefault();
	
	let editForm = document.editForm;
	
	let id = editForm.firstElementChild.textContent;
	
	let book = {
		title: editForm.title.value,
		author: editForm.author.value,
		synopsis: editForm.synopsis.value,
		coverArt: editForm.coverArt.value
	};
	console.log(JSON.stringify(book));
	
	let xhr = new XMLHttpRequest();
	
	xhr.open("PUT", "api/books/" + id);
	
	xhr.setRequestHeader("Content-Type", "Application/JSON");
	
	xhr.onreadystatechange = () => {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				console.log(JSON.parse(xhr.responseText));
				displayBook(JSON.parse(xhr.responseText));
			} else {
				console.error(xhr.responseText);
			}
		}
	};
	
	xhr.send(JSON.stringify(book));
	
}



function deleteBookButton() {
	
	let id = document.getElementById("displayBook").firstElementChild.textContent;
	console.log(id);
	deleteBook(id);
	
}

function deleteBook(id) {
	let xhr = new XMLHttpRequest();
	
	xhr.open("DELETE", "api/books/" + id);
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 204) {
				loadBooks();
				document.getElementById("displayBook").textContent = "";
			} else if (xhr.status === 404) {
				console.log(xhr.responseText);
			}
		}
	};
	
	xhr.send();
}
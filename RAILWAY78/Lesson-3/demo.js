console.log(123)

function Account(id, name, role, age) {
    this.id = id;
    this.name = name;
    this.role = role;
    this.age = age;
}

let acc1 = new Account(1, "Tran lekien", "admin", 20)
console.log(acc1)

function test() {
    console.log("Click")
}

function test2() {
    alert("Không được copy!")
}

function delete2() {
    $("#demo").alert("show")
}

function login() {

    let input = document.getElementById("demo").value;

    let user = "lkt";
    let pass = "123456";

    if (user != "ADMIN") {
        alert("Sai user");
        return;
    }
    if (pass != "123456") {
        alert("Sai pass");
        return;
    }

    alert("Bạn đã đăng nhập thành công!")
    localStorage.setItem("user", user)
    localStorage.setItem("pass", pass)

    console.log(localStorage.getItem("user"))
}
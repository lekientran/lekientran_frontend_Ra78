let classRooms = [];
let pageSizeRoom = 6;
let pageNumberRoom = 1;
let sortBy = "id";
let sortType = "asc";

function SearchRoomRequest(pageSizeRoom, pageNumberRoom, sortBy, sortType) {
    this.pageSize = pageSizeRoom;
    this.pageNumber = pageNumberRoom;
    this.sortBy = sortBy;
    this.sortType = sortType;
}

$(function () {
    console.log("Room")
    buildClassRoomPage();
})

function buildClassRoomPage() {
    classRooms = [];
    GetListClassRooms();
}

//------------------------------------ gọi api GetAllZoom
async function GetListClassRooms() {
    // var url = "http://localhost:8080/api/v1/class?sortByClassName=true&sortByStartDate=true";
    // $.get(url, function (data, status) {
    //     //error
    //     if (status == "error") {
    //         alert("Error when loading data");
    //         return;
    //     }
    //     class_s = data;
    //     console.log(class_s);
    //     filltoTable();
    // });
    fetch('./assets/data/class-room.json')
        .then((response) => response.json())
        .then((json) => {
            fillRoomToTable(json.content);
            buildPaginationRoom(json.number + 1, json.totalPages);
        });
}

function fillRoomToTable(json) {
    if (json) {
        classRooms = json;
    }
    // check form trống để k lặp lại khi chuyền data
    $('tbody').empty();
    var index = 1;
    console.log(classRooms);
    classRooms.forEach(function (item) {
        $('tbody').append(
            '<tr>' +
            '<td>' + (index++) + '</td>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.address + '</td>' +
            '<td>' + item.size + '</td>' +
            '<td>' + item.note + '</td>' +
            '<td>' +
            '<a class="edit" title="go to  detail" data-toggle="tooltip" onclick="editRoom(' +
            item.id + ')"><i class="ti-pencil m-1 text-warning" style="font-size:24px; cursor: pointer;"></i></a>' +
            '<a class="edit" title="go to  detail" data-toggle="tooltip" onclick="confirmDeleteRoom(' +
            item.id + ')"><i class="ti-trash m-1 text-danger" style="font-size:24px; cursor: pointer;"></i></a>' +
            '</td>' +
            '</tr>'
        )
    });
}

function buildPaginationRoom(number, totalPages) {
    // kiểm tra nếu trang hiện tại là trang đầu -> disable đi
    if (number === 1) {
        $("#pagination-room").empty().append(
            `<li class="page-item">
            <a class="page-link disabled" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>`);
    } else {
        $("#pagination-room").empty().append(
            `<li class="page-item">
            <a class="page-link" href="#" aria-label="Previous" onclick="prePageRoom()">
                <span aria-hidden="true">&laquo;</span>
                <span class="sr-only">Previous</span>
            </a>
        </li>`);
    }

    // Dùng hàm for để build ra số trang. Kiểm tra xem trang hiện tại là bao nhiêu thì background vàng
    for (let index = 1; index <= totalPages; index++) {
        if (number === (index)) {
            $('#pagination-room').append(`<li class="page-item "><a class="page-link bg-primary" href="#" onclick="chosePageRoom(` + index + `)">` + index + `</a></li>`);
        } else {
            $('#pagination-room').append(`<li class="page-item"><a class="page-link" href="#" onclick="chosePageRoom(` + index + `)">` + index + `</a></li>`);
        }
    }

    // Kiểm tra nếu trang hiện tại là trang cuối -> disable đ
    if (number === totalPages) {
        $("#pagination-room").append(
            `<li class="page-item">
            <a class="page-link" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </a>
        </li>`);
    } else {
        $("#pagination-room").append(
            `<li class="page-item">
            <a class="page-link" href="#" aria-label="Next" onclick="nextPageRoom()">
                <span aria-hidden="true">&raquo;</span>
                <span class="sr-only">Next</span>
            </a>
        </li>`);
    }
}

function chosePageRoom(page) {
    event.preventDefault()
    pageNumberZoom = page;
    getListZoom();
}
function prePageRoom() {
    event.preventDefault()
    pageNumberZoom--;
    getListZoom();
}

function nextPageRoom() {
    event.preventDefault()
    pageNumberZoom++;
    getListZoom();
}

function addRoom() {
    resetFormEditRoom();
    $('#roomModal').modal('show')
}

function editRoom(roomId) {
    let room = classRooms.find(room => room.id === roomId)
    console.log(room);
    resetFormEditRoom();
    $('#roomIdToSave').val(room.id);
    $('#roomName').val(room.name);
    $("#roomAddress").val(room.address);
    $("#roomSize").val(room.size);
    $("#roomNote").val(room.note);
    $('#roomModal').modal('show')
}

function Zoom(id, name, address, size, note) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.size = size;
    this.note = note;
}

function saveRoom() {
    // Lấy các thông số để lưu
    let id = $("#roomIdToSave").val();
    let name = $("#roomName").val();
    let address = $("#roomAddress").val();
    let size = $("#roomSize").val();
    let note = $("#roomNote").val();
    let room = new Zoom(id, name, address, size, note);
    classRooms.push(room);
    fillRoomToTable();
    // --------------------- Kiểm tra id có giá trị -> call api UPDATE ROOM
    // --------------------- ko có giá trị id -> call api CREATE ROOM

    $('#roomModal').modal('hide')
    let text = id ? "Update thành công" : "Thêm mới thành công"
    $('#roomModal').modal('hide')
    showAlrtSuccess(text);
}

function resetFormEditRoom() {
    document.getElementById("roomIdToSave").value = "";
    document.getElementById("roomName").value = "";
    document.getElementById("roomAddress").value = "";
    document.getElementById("roomSize").value = "";
    document.getElementById("roomNote").value = "";
}

function confirmDeleteRoom(roomId) {
    $('#confirmDeleteRoom').modal('show')
    $('#roomIdToDelete').val(roomId)
}

function deleteRoom() {
    let roomId = document.getElementById("roomIdToDelete").value;
    console.log(roomId);
    $('#confirmDeleteRoom').modal('hide')
    showAlrtSuccess("Xoá phòng học thành công!");
}

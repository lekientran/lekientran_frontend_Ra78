$(function () {
    getListAccount();
    console.log("chạy hàm này đầu tiên khi load JS");
})
const baseUrl = "https://653f8d809e8bd3be29e0ca71.mockapi.io/Account";

function getListAccount() {
    // call API
    $.ajax({
        url: baseUrl,
        type: 'GET',
        contentType: 'application/json', // Định nghĩa định dạng dữ liệu truyền vào là json
        // data: JSON.stringify(request),
        error: function (err) {
            // Hành động khi apii bị lỗi
            console.log(err)
        },
        success: function (data) {
            // Hành động khi thành công
            console.log(data)
            fillAccountToTable(data)
        }
    });

}

function fillAccountToTable(data) {
    console.log(data);
    $("tbody").empty()
    for (let index = 0; index < data.length; index++) {
        const element = data[index];
        console.log(element)
        $("tbody").append(
            `
            <tr>
                <th scope="row">${index + 1}</th>
                <td>
                    <img style="width: 120px;"
                        src="${element.avatar}">
                </td>
                <td>${element.name}</td>
                <td>${element.address}</td>
                <td>${element.department}</td>
                <td>
                <button type="button" class="btn" data-toggle="modal" data-target="#exampleModal">
                    <i class="fa fa-pencil" style="font-size: 30px; color: #ffc008;"></i>
                </button>
                <button type="button" class="btn" data-toggle="modal" data-target="#exampleModal">
                    <i class="fa fa-trash" style="font-size: 30px; color: red;" 
                    onclick="confirmDeleteAccount("${element.id})"></i>
                    </button>
                </td>
            </tr>
            `
        )
    }
}

function confirmDeleteAccount(id) {
    console.log(id)
    // Gán ID vào 1 biến, localstorage, input
    $("#idAccountToDelete").val(id)
}

function deleteAccount() {
    const accountId = $("#idAccountToDelete").val();
    alert("Đã xóa thành công account có id là " + accountId);
// call API
    $.ajax({
        url: baseUrl + "/" + accountId,
        type: 'DELETE',
        contentType: 'application/json', // Định nghĩa định dạng dữ liệu truyền vào là json
        // data: JSON.stringify(request),
        error: function (err) {
            // Hành động khi apii bị lỗi
            console.log(err)
        },
        success: function (data) {
            // Hành động khi xóa thành công
            $('#exampleModal').modal('hide')
            getListAccount();
        }
    });
}


// function onSave(){
//     const accountID = $(#idAccountToUpdate).val();

// }
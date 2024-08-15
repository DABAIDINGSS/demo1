
$(document).ready(function() {
    $("#loadData").click(function() {
        $.ajax({
            url: '/test/cellphones/query',  // API端点
            method: 'GET',           // 请求方式
            dataType: 'json',
            success: function(data) {
                if (data && Array.isArray(data)) {
                    var table = $('#cellphoneTable');
                    table.empty(); // 清空旧数据

                    // 创建表头
                    //var header = '<tr><th>ID</th><th>Summary</th><th>Legend</th><th>Protection</th><th>Sale</th><th>Place</th><th>Price</th><th>Seller</th><th>Monthly Sales</th><th>Comments</th></tr>';
                    //table.append(header);

                    // 遍历每个手机数据
                    data.forEach(function(cellphone) {
                        // 创建一个表格行并填充数据
                        var row = $('<tr>')
                            .append(`<td>${cellphone.id}</td>`)
                            .append(`<td>${cellphone.summary}</td>`)
                            .append(`<td>${cellphone.legend}</td>`)
                            .append(`<td>${cellphone.protection}</td>`)
                            .append(`<td>${cellphone.sale}</td>`)
                            .append(`<td>${cellphone.place}</td>`)
                            .append(`<td>${cellphone.price}</td>`)
                            .append(`<td>${cellphone.seller}</td>`)
                            .append(`<td>${cellphone.msales}</td>`)
                            .append(`<td>${cellphone.comments}</td>`);
                        table.append(row);
                    });
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error loading cellphones:', textStatus, errorThrown);
            }
        });

    });
    $("#special_query").click(function (){
        var dataObj = {
            protection: $("#Protection").val()
        };
        console.log("Sending data to server:", dataObj);
        $.ajax({
            url: '/test/cellphones/queryByProtected',  // API端点
            method: 'POST',           // 请求方式

            data:JSON.stringify(dataObj),
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            success: function(data) {
                if (data && Array.isArray(data)) {
                    var table = $('#cellphoneTable');
                    table.empty(); // 清空旧数据

                    // 创建表头
                    //var header = '<tr><th>ID</th><th>Summary</th><th>Legend</th><th>Protection</th><th>Sale</th><th>Place</th><th>Price</th><th>Seller</th><th>Monthly Sales</th><th>Comments</th></tr>';
                    //table.append(header);

                    // 遍历每个手机数据
                    data.forEach(function(cellphone) {
                        // 创建一个表格行并填充数据
                        var row = $('<tr>')
                            .append(`<td>${cellphone.id}</td>`)
                            .append(`<td>${cellphone.summary}</td>`)
                            .append(`<td>${cellphone.legend}</td>`)
                            .append(`<td>${cellphone.protection}</td>`)
                            .append(`<td>${cellphone.sale}</td>`)
                            .append(`<td>${cellphone.place}</td>`)
                            .append(`<td>${cellphone.price}</td>`)
                            .append(`<td>${cellphone.seller}</td>`)
                            .append(`<td>${cellphone.msales}</td>`)
                            .append(`<td>${cellphone.comments}</td>`);
                        table.append(row);
                    });
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error loading cellphones:', textStatus, errorThrown);
            }
        });
    })
    $("#dynamic_special_query").click(function () {
        var dataObj = {
            protection: $("#Protection").val(),
            seller: $("#seller").val(),
            summary: $("#summary").val(),
            place: $("#place").val()
        };
        $.ajax({
            url: '/test/cellphones/query_dynamic',  // API端点
            method: 'POST',           // 请求方式

            data:JSON.stringify(dataObj),
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            success: function(data) {
                if (data && Array.isArray(data)) {
                    var table = $('#cellphoneTable');
                    table.empty(); // 清空旧数据

                    // 创建表头
                    //var header = '<tr><th>ID</th><th>Summary</th><th>Legend</th><th>Protection</th><th>Sale</th><th>Place</th><th>Price</th><th>Seller</th><th>Monthly Sales</th><th>Comments</th></tr>';
                    //table.append(header);

                    // 遍历每个手机数据
                    data.forEach(function(cellphone) {
                        // 创建一个表格行并填充数据
                        var row = $('<tr>')
                            .append(`<td>${cellphone.id}</td>`)
                            .append(`<td>${cellphone.summary}</td>`)
                            .append(`<td>${cellphone.legend}</td>`)
                            .append(`<td>${cellphone.protection}</td>`)
                            .append(`<td>${cellphone.sale}</td>`)
                            .append(`<td>${cellphone.place}</td>`)
                            .append(`<td>${cellphone.price}</td>`)
                            .append(`<td>${cellphone.seller}</td>`)
                            .append(`<td>${cellphone.msales}</td>`)
                            .append(`<td>${cellphone.comments}</td>`);
                        table.append(row);
                    });
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error loading cellphones:', textStatus, errorThrown);
            }
        });
    })
    $("#insert_phone").click(function () {
        var dataObj = {
            protection: $("#Protection").val(),
            seller: $("#seller").val(),
            summary: $("#summary").val(),
            place: $("#place").val()
        };
        $.ajax({
            url: '/test/cellphones/insert',  // API端点
            method: 'POST',           // 请求方式

            data:JSON.stringify(dataObj),
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            success: function(data) {
                alert("添加成功")
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.error('Error insert cellphones:', textStatus, errorThrown);
            }
        });
    })
    $("#export").click(function () {
        var dataObj = {
            protection: $("#Protection").val(),
            seller: $("#seller").val(),
            summary: $("#summary").val(),
            place: $("#place").val()
        };

        // 创建一个用于提交的表单
        var form = $('<form method="POST" action="/test/cellphones/export">');
        $('body').append(form);
        // 将参数添加到表单
        $.each(dataObj, function(key, value) {
            $(form).append($('<input type="hidden" name="' + key + '" value="' + value + '" />'));
        });
        // 提交表单
        form.submit();
        // 删除表单
        form.remove();
    });

});

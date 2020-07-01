package com.inventorymanagement.controller

import com.inventorymanagement.constants.ApiConstants
import com.inventorymanagement.constants.ApiConstants.Companion.API_V1_ORDER
import com.inventorymanagement.constants.Constants
import com.inventorymanagement.extension.getCommonResponse
import com.inventorymanagement.extension.getErrorResponse
import com.inventorymanagement.extension.idValid
import com.inventorymanagement.model.OrderMaster
import com.inventorymanagement.model.base.BaseResponse
import com.inventorymanagement.model.base.CommonResponse
import com.inventorymanagement.model.base.ErrorResponse
import com.inventorymanagement.repository.OrderMasterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(API_V1_ORDER)
class OrderController {

    @Autowired
    private val orderMasterRepo: OrderMasterRepository? = null

    @GetMapping(ApiConstants.ENDPOINT_ORDER)
    fun getAllOrders(): BaseResponse<MutableList<OrderMaster>> {
        val orderListBaseResponse = BaseResponse<MutableList<OrderMaster>>()
        val orderList = orderMasterRepo?.findAll()
        if (orderList.isNullOrEmpty()) {
            orderListBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_order_found)
        } else {
            orderListBaseResponse.data = orderList
        }
        return orderListBaseResponse
    }

    @GetMapping(ApiConstants.ENDPOINT_ORDER_GET)
    fun getOrderById(@PathVariable("id") id: Int): BaseResponse<OrderMaster> {
        val orderBaseResponse = BaseResponse<OrderMaster>()
        try {
            val orderOptional = orderMasterRepo?.findById(id)
            if (!orderOptional?.isEmpty!!) {
                orderBaseResponse.data = orderOptional.get()
            } else {
                orderBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_order_found)
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            orderBaseResponse.errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_no_order_found)
        }
        return orderBaseResponse
    }

    @PostMapping(ApiConstants.ENDPOINT_ORDER_SAVE)
    fun saveOrder(@RequestBody saveOrder: OrderMaster): BaseResponse<CommonResponse> {
        val saveOrderBaseResponse = BaseResponse<CommonResponse>()
        try {
            orderMasterRepo?.save(saveOrder)
            saveOrderBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_order_saved)
        } catch (e: Exception) {
            e.printStackTrace()
            println(e.localizedMessage)
            val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
            saveOrderBaseResponse.errorResponse = errorResponse
        }
        return saveOrderBaseResponse
    }

    @PutMapping(ApiConstants.ENDPOINT_ORDER_UPDATE)
    fun updateOrder(@RequestBody updateOrder: OrderMaster): BaseResponse<CommonResponse> {
        val updateOrderBaseResponse = BaseResponse<CommonResponse>()

        val orderMasterOptional = orderMasterRepo?.findById(updateOrder.id)
        if (orderMasterOptional == null) {
            // type is not exist
            try {
                orderMasterRepo?.save(updateOrder)
                updateOrderBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_order_updated)
            } catch (e: Exception) {
                e.printStackTrace()
                println(e.localizedMessage)
                val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                updateOrderBaseResponse.errorResponse = errorResponse
            }
        } else {
            // type is exist
            if (updateOrder.id.equals(orderMasterOptional.get().id)) {
                updateOrderBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_no_change_updated)
            } else {
                val errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_order_exist)
                updateOrderBaseResponse.errorResponse = errorResponse
            }
        }
        return updateOrderBaseResponse
    }

    @PostMapping(ApiConstants.ENDPOINT_ORDER_DELETE)
    fun deleteOrder(@RequestBody deleteOrder: OrderMaster): BaseResponse<CommonResponse> {
        val deleteCommonBaseResponse = BaseResponse<CommonResponse>()
        var orderValidatorPair = deleteOrder.idValid()
        if (orderValidatorPair.first) {
            val orderMasterOptional = orderMasterRepo?.findById(deleteOrder.id)
            if (!orderMasterOptional?.isEmpty!!) {
                // type is not exist
                try {
                    val orderMaster = orderMasterOptional.get()
                    orderMaster.isDeleted = true
                    orderMasterRepo?.save(orderMaster)
                    deleteCommonBaseResponse.data = CommonResponse().getCommonResponse(Constants.msg_order_deleted)
                } catch (e: Exception) {
                    e.printStackTrace()
                    val errorResponse = ErrorResponse().getErrorResponse(0, e.localizedMessage)
                    deleteCommonBaseResponse.errorResponse = errorResponse
                }
            } else {
                // type is exist
                val errorResponse = ErrorResponse().getErrorResponse(100, Constants.msg_order_exist)
                deleteCommonBaseResponse.errorResponse = errorResponse
            }
        } else {
            val errorResponse = ErrorResponse().getErrorResponse(100, orderValidatorPair.second)
            deleteCommonBaseResponse.errorResponse = errorResponse
        }
        return deleteCommonBaseResponse
    }

}
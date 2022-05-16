package com.lhj.converter;

import com.lhj.dto.OrderDTO;
import com.lhj.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换器:orderMaster转成orderDTO
 * @author lhj on 2022/5/16
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        //把orderMaster中的属性copy至orderDTO
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        List<OrderDTO> orderDTOList = orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
        return orderDTOList;
    }
}

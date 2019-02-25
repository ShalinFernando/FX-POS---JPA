package lk.ijse.dep.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO extends SuperDTO{

    private String id;
    private LocalDate date;
    private CustomerDTO customerDTO;
    private List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(String id, LocalDate date, CustomerDTO customerDTO, List<OrderDetailDTO> orderDetailDTOS) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
        this.orderDetailDTOS = orderDetailDTOS;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<OrderDetailDTO> getOrderDetailDTOS() {
        return orderDetailDTOS;
    }

    public void setOrderDetailDTOS(List<OrderDetailDTO> orderDetailDTOS) {
        this.orderDetailDTOS = orderDetailDTOS;
    }
}

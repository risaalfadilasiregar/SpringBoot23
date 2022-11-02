package id.sinaukoding.latihan.service;

import id.sinaukoding.latihan.model.Order;
import id.sinaukoding.latihan.model.Staff;
import id.sinaukoding.latihan.model.Store;
import id.sinaukoding.latihan.model.Customer;
import id.sinaukoding.latihan.model.dto.OrderDTO;
import id.sinaukoding.latihan.model.mapper.OrderMapper;
import id.sinaukoding.latihan.model.mapper.StaffMapper;
import id.sinaukoding.latihan.model.mapper.StoreMapper;
import id.sinaukoding.latihan.model.mapper.CustomerMapper;
import id.sinaukoding.latihan.repository.CustomerRepository;
import id.sinaukoding.latihan.repository.OrderRepository;
import id.sinaukoding.latihan.repository.StaffRepository;
import id.sinaukoding.latihan.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> data = repository.findAllByIsDeleted(false);

        return OrderMapper.INSTANCE.toDtoList(data);
    }

    @Transactional
    public OrderDTO createData(OrderDTO param){
        Customer customer = CustomerMapper.INSTANCE.dtoToEntity(param.getCustomer());

        if (param.getCustomer() != null) {
            Customer resCustomer = null;

            if (customer.getCustomerId() != null) {
                resCustomer = customerRepository.getById(customer.getCustomerId());
            }
            customer.setCreatedDate(resCustomer != null ? resCustomer.getCreatedDate() : new Date());

            customer = customerRepository.save(customer);
        }

        Staff staff = StaffMapper.INSTANCE.dtoToEntity(param.getStaff());

        if (param.getStaff() != null) {
            Staff resStaff = null;

            if (staff.getStaffId() != null) {
                resStaff = staffRepository.getById(staff.getStaffId());
            }
            staff.setCreatedDate(resStaff != null ? resStaff.getCreatedDate() : new Date());

            staff = staffRepository.save(staff);
        }

        Store store = StoreMapper.INSTANCE.dtoToEntity(param.getStore());

        if (param.getStore() != null) {
            Store resStore = null;

            if (store.getStoreId() != null) {
                resStore = storeRepository.getById(store.getStoreId());
            }
            store.setCreatedDate(resStore != null ? resStore.getCreatedDate() : new Date());

            store = storeRepository.save(store);
        }

        Order data = OrderMapper.INSTANCE.dtoToEntity(param);
        data.setCustomer(customer);
        data.setStaff(staff);
        data.setStore(store);
        data.setCreatedDate(new Date());

        data = repository.save(data);

        return OrderMapper.INSTANCE.entityToDto(data);
    }

    @Transactional
    public OrderDTO updateData(OrderDTO param, int id){
        Order data = repository.findById(id).get();

        if (data != null){
            data.setOrderStatus(param.getOrderStatus() != null ? param.getOrderStatus() : data.getOrderStatus());
            data.setOrderDate(param.getOrderDate() != null ? param.getOrderDate() : data.getOrderDate());
            data.setRequiredDate(param.getRequiredDate() != null ? param.getRequiredDate() : data.getRequiredDate());
            data.setShippedDate(param.getShippedDate() != null ? param.getShippedDate() : data.getShippedDate());
            data.setUpdatedDate(new Date());

            return OrderMapper.INSTANCE.entityToDto(repository.save(data));
        }

        return null;
    }

    @Transactional
    public boolean deleteData(int id){
        Order data = repository.findById(id).get();

        if (data != null){
            data.setDeleted(true);

            repository.save(data);

            return true;
        }

        return false;
    }
}
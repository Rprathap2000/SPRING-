package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.entity.PhoneNumber;
import com.nt.repository.ICustomerRepository;
import com.nt.repository.IPhonesRepository;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

    @Autowired
    private ICustomerRepository custRepo;

    @Autowired
    private IPhonesRepository phonesRepo;

    @Override
    public String saveDateUsingParent() {
        //create parent object
        Customer cust = new Customer("raja", "hyd");

        //create child objects
        PhoneNumber ph1 = new PhoneNumber(99999999L, "aritel");
        PhoneNumber ph2 = new PhoneNumber(88888888L, "jio");

        //set child to parent
        ph1.setCustomer(cust);
        ph2.setCustomer(cust);

        //set childs to parent
        Set<PhoneNumber> childs = Set.of(ph1, ph2);
        cust.setPhonesInfo(childs);

        //save parent to child
        int idVal = custRepo.save(cust).getCno();

        return "Parent to Childs objs are saved with the id value:" + idVal;
    }

    @Override
    public String saveDataUsingChild() {
        //create parent object
        Customer cust = new Customer("raja", "hyd");

        //create child objects
        PhoneNumber ph1 = new PhoneNumber(77777777L, "aritel");
        PhoneNumber ph2 = new PhoneNumber(66666666L, "jio");

        //set parent to child 
        ph1.setCustomer(cust);
        ph2.setCustomer(cust);

        //set Parent to Child
        Set<PhoneNumber> childs = Set.of(ph1, ph2);
        cust.setPhonesInfo(childs);

        //save objects using child
        phonesRepo.saveAll(childs);

        return "Childs to parents objs are saved";
    }

    @Override
    public void loadDataUsingParent() {
        Iterable<Customer> it = custRepo.findAll();
        it.forEach(cust -> {
            System.out.println("parent::" + cust);
            //Associated child objects
            Set<PhoneNumber> childs = cust.getPhonesInfo();
            childs.forEach(ph -> {
                System.out.println("Child::" + ph);
            });
        });
    }

    @Override
    public void loadDataUsingChild() {
        Iterable<PhoneNumber> it = phonesRepo.findAll();
        it.forEach(ph -> {
            System.out.println("Child::" + ph);
            //get the Association parent
            Customer cust = ph.getCustomer();
            System.out.println("parent::" + cust);
        });
    }

    @Override
    public void deleteDataUsingParent() {
        //Load parent object
        Optional<Customer> opt = custRepo.findById(20);
        if (opt.isPresent()) {
            //get Customer object
            Customer cust = opt.get();
            custRepo.delete(cust);
            System.out.println("Customer and his PhoneNumbers are deleted");
        } else {
            System.out.println("Customer is not found");
        }
    }

    @Override
    public void deleteAllChildsOfAParent() {
        //Load parent object
        Optional<Customer> opt = custRepo.findById(20);
        if (opt.isPresent()) {
            //get Customer object
            Customer cust = opt.get();
            //get Child of a Parent
            Set<PhoneNumber> childs = cust.getPhonesInfo();
            //nullifying parent from the child
            childs.forEach(ph -> {
                ph.setCustomer(null);
            });
            //delete all the child
            phonesRepo.deleteAllInBatch(childs);
            System.out.println("All the childs of a Parent are deleted");
        } else {
            System.out.println("Parent not found");
        }
    }

    @Override
    public void addNewChildToExistingChilds() {
        //Load parent object
        Optional<Customer> opt = custRepo.findById(20);
        if (opt.isPresent()) {
            //get Customer object
            Customer cust = opt.get();
            //get existing child of a Parent
            Set<PhoneNumber> childs = cust.getPhonesInfo();
            //create new PhoneNumber
            PhoneNumber ph = new PhoneNumber(77777777L, "vi");
            //set new child to parent
            ph.setCustomer(cust);
            //add new child to existing child and update the child
            childs.add(ph);
            custRepo.save(cust);
            phonesRepo.save(ph);
            System.out.println("New child is added to existing children of a parent");
        } else {
            System.out.println("Parent not found");
        }
    }

    @Override
    public void deleteDataUsingChild() {
        //Load parent object
        Optional<Customer> opt = custRepo.findById(20);
        if (opt.isPresent()) {
            //get Customer object
            Customer cust = opt.get();
            //get all children of a parent
            Set<PhoneNumber> childs = cust.getPhonesInfo();
            //delete all children
            childs.forEach(ph -> {
                phonesRepo.delete(ph);
            });

            System.out.println("All children and its associated data are deleted");
        } else {
            System.out.println("Parent not found");
        }
    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Object[]> showParentsToChildsDataUsingJoins() {
        //use repo
        return custRepo.fetchParentToChildsDataUsingJoins();
    }
}

package com.tnsif.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    public Store getStoreById(int id) {
        return storeRepository.findById(id).orElse(null);
    }

    public Store addStore(Store store) {
        return storeRepository.save(store);
    }
    public Store updateStoreAttributes(int id, Store storeDetails) {
        Optional<Store> optionalStore = storeRepository.findById(id);
        if (optionalStore.isPresent()) {
            Store existingStore = optionalStore.get();
            if (storeDetails.getName() != null) {
                existingStore.setName(storeDetails.getName());
            }
            if (storeDetails.getCategory() != null) {
                existingStore.setCategory(storeDetails.getCategory());
            }
            if (storeDetails.getContactInfo() != null) {
                existingStore.setContactInfo(storeDetails.getContactInfo());
            }
            if (storeDetails.getLocation() != null) {
                existingStore.setLocation(storeDetails.getLocation());
            }
            if (storeDetails.getOperatingHours() != null) {
                existingStore.setOperatingHours(storeDetails.getOperatingHours());
            }
            return storeRepository.save(existingStore);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteStore(int id) {
        storeRepository.deleteById(id);
    }
}

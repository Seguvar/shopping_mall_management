package com.tnsif.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable int id) {
        Store store = storeService.getStoreById(id);
        return store != null ? ResponseEntity.ok(store) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Store> addStore(@RequestBody Store store) {
        Store newStore = storeService.addStore(store);
        return ResponseEntity.ok(newStore);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Store> updateStoreAttributes(@PathVariable int id, @RequestBody Store storeDetails) {
        Store updatedStore = storeService.updateStoreAttributes(id, storeDetails);
        return updatedStore != null ? ResponseEntity.ok(updatedStore) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}

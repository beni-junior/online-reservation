package ir.hatami.onlinereservation.controller.rest;

import ir.hatami.onlinereservation.domain.dto.DoctorCreateDto;
import ir.hatami.onlinereservation.domain.dto.DoctorUpdateDto;
import ir.hatami.onlinereservation.domain.dto.common.DetailsDto;
import ir.hatami.onlinereservation.domain.dto.common.ListDto;
import ir.hatami.onlinereservation.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {
    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Optional<List<? extends ListDto>>> getAllDoctors() {
        return ResponseEntity.ok(this.service.load());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<DetailsDto>> getDoctorById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(this.service.load(id));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody DoctorCreateDto createDto) {
        this.service.create(createDto);
        return ResponseEntity.ok("suc.creation");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable("id") UUID id, @RequestBody DoctorUpdateDto updateDto) {
        this.service.update(id, updateDto);
        return ResponseEntity.ok("suc.update");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        this.service.delete(id);
        return ResponseEntity.ok("suc.del");
    }
}

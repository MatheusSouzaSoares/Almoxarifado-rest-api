package com.matheus.Almoxarifado.Controller;

import com.matheus.Almoxarifado.Model.FuncionarioModel;
import com.matheus.Almoxarifado.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class FuncionarioController {
    @Autowired
    private FuncionarioRepository repository;

    @GetMapping(path = "/api/user/{id}")
    public ResponseEntity consulta(@PathVariable ("id") Integer Id)
    {
        return repository.findById(Id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping (path = "api/user/save")
    public FuncionarioModel salvar(@RequestBody FuncionarioModel f)
    {
        return repository.save(f);
    }
    @GetMapping(path="/api/user/all")
    public List<FuncionarioModel> FindAll(){

        return repository.findAll();
    }
    @GetMapping(path ="api/user/nome/{nome}")
    public ResponseEntity<List<FuncionarioModel>> Findbyname(@PathVariable String nome)
    {
       return new ResponseEntity<List<FuncionarioModel>>(repository.findByNomeContaining(nome), HttpStatus.OK);
    }
    @GetMapping(path = "api/user/cargo/{cargo}")
    public ResponseEntity<List<FuncionarioModel>> Findbycargo(@PathVariable String cargo)
    {
       return new ResponseEntity<List<FuncionarioModel>>(repository.findByCargoContaining(cargo),HttpStatus.OK);
    }

    @DeleteMapping(path = "api/user/delete/{id}")
    public String deletarbyId(@PathVariable Integer id)
    {
        repository.deleteById(id);
        return "Sucesso";
    }
    @PostMapping(path = "api/user/update")
    public FuncionarioModel updateNome(@RequestBody FuncionarioModel fm)
    {
        FuncionarioModel f = new FuncionarioModel();
        f = repository.findById(fm.getId()).get();
        f.setNome(fm.getNome());
        f.setCargo(fm.getCargo());
        return repository.save(f);
    }
}

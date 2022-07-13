package com.loija.core.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loija.core.enums.Manufactures;
import com.loija.core.enums.Roles;
import com.loija.core.enums.TypesProduct;
import com.loija.core.model.Manufacture;
import com.loija.core.model.Material;
import com.loija.core.model.MyUser;
import com.loija.core.model.Product;
import com.loija.core.model.Rol;
import com.loija.core.model.TypeProduct;
import com.loija.core.repository.ManufactureRepository;
import com.loija.core.repository.MaterialRepository;
import com.loija.core.repository.ProductRepository;
import com.loija.core.repository.TypeProductRepository;
import com.loija.core.service.RolService;
import com.loija.core.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Service
public class DataCreate implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private RolService rolService;
    @Autowired 
    private ManufactureRepository manufactureRepo;
    @Autowired
    private MaterialRepository materialRepo;
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private TypeProductRepository typeRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
    	/*
    	
    	//ROLES
    	Rol adminRol = new Rol(Roles.ROLE_ADMIN);
    	Rol managerRol = new Rol(Roles.ROLE_MANAGER);
    	Rol userRol = new Rol(Roles.ROLE_USER);
    	rolService.addRol(adminRol);
    	rolService.addRol(managerRol);
    	rolService.addRol(userRol);
    	//fin ROLES
    	
    	//MANUFACTURES
    	Manufacture plegad = new Manufacture(Manufactures.PLEGADORA);
    	Manufacture soldad = new Manufacture(Manufactures.SOLDADURA);
    	Manufacture corteLaser = new Manufacture(Manufactures.CORTE_LASER);
    	Manufacture dobladVar = new Manufacture(Manufactures.DOBLADORA_VARILLA);
    	Manufacture punzon = new Manufacture(Manufactures.PUNZONADORA);
    	Manufacture otroManu = new Manufacture(Manufactures.OTRO);
    	manufactureRepo.save(plegad);
    	manufactureRepo.save(soldad);
    	manufactureRepo.save(corteLaser);
    	manufactureRepo.save(dobladVar);
    	manufactureRepo.save(punzon);
    	manufactureRepo.save(otroManu);
    	//fin MANUFACTURES
    	
    	//TYPESPRODUCT
    	TypeProduct espejo = new TypeProduct(TypesProduct.ESPEJO);
    	TypeProduct zapat = new TypeProduct(TypesProduct.ZAPATERO);
    	TypeProduct pant = new TypeProduct(TypesProduct.PANTALONERO);
    	TypeProduct barra = new TypeProduct(TypesProduct.BARRA);
    	TypeProduct corb = new TypeProduct(TypesProduct.CORBATERO);
    	TypeProduct cint = new TypeProduct(TypesProduct.CINTURONERO);
    	TypeProduct elev = new TypeProduct(TypesProduct.ELEVADOR);
    	TypeProduct cesta = new TypeProduct(TypesProduct.CESTA);
    	TypeProduct otroType = new TypeProduct(TypesProduct.OTRO);
    	typeRepo.save(espejo);
    	typeRepo.save(zapat);
    	typeRepo.save(pant);
    	typeRepo.save(barra);
    	typeRepo.save(corb);
    	typeRepo.save(cint);
    	typeRepo.save(elev);
    	typeRepo.save(cesta);
    	typeRepo.save(otroType);
    	//fin TYPESPRODUCT
    	
    	//PRODUCTS
    	Product donyana = new Product(pant, "Doñana");
    	Product moncayo = new Product(pant, "Moncayo");
    	Product lagoSanabria = new Product(espejo, "Lago de Sanabria");
    	Product osoPardo = new Product(zapat, "Oso Pardo");
    	Product lagoBany = new Product(zapat, "Lago de Banyoles");
    	Product quebrant = new Product(barra, "Quebrantahuesos");
    	Product otroProduct = new Product(otroType, "Otros");
    	productRepo.save(donyana);
    	productRepo.save(moncayo);
    	productRepo.save(lagoSanabria);
    	productRepo.save(osoPardo);
    	productRepo.save(lagoBany);
    	productRepo.save(quebrant);
    	productRepo.save(otroProduct);
    	//fin PRODUCTS
    	
    	//MATERIALS
        Set<Manufacture> manufactures = new HashSet<>();
        manufactures.add(corteLaser);
        manufactures.add(plegad);
    	Material trasMonIzq = new Material("Trasera Izquierda 3mm", moncayo, manufactures);
    	Material trasMonDer = new Material("Trasera Derecha 3mm", moncayo, manufactures);
    	Material trasDonyana = new Material("Trasera 3mm", donyana, manufactures);
    	Material frontDon = new Material("Frontal Acero Inox ", donyana, manufactures);
    	Material trasEsp = new Material("Chapa Trasera 3mm", lagoSanabria, manufactures);
    	manufactures.remove(plegad);
    	manufactures.add(punzon);
    	Material chapaQueb = new Material("Chapa Punzonada 3mm ", quebrant, manufactures);
    	manufactures.clear();
    	manufactures.add(dobladVar);
    	Material perchMon = new Material("Percha Estandar 5Ø", moncayo, manufactures);
    	Material perchMang = new Material("Percha con mango", otroProduct, manufactures);
    	manufactures.add(soldad);
    	Material zapOso = new Material("Zapatero Oso Pardo 60-100", osoPardo, manufactures);
    	Material zapLago = new Material("Zapatero Lago Banyoles 100-140", lagoBany, manufactures);
    	materialRepo.save(trasMonIzq);
    	materialRepo.save(trasMonDer);
    	materialRepo.save(trasDonyana);
    	materialRepo.save(frontDon);
    	materialRepo.save(trasEsp);
    	materialRepo.save(chapaQueb);
    	materialRepo.save(perchMon);
    	materialRepo.save(perchMang);
    	materialRepo.save(zapOso);
    	materialRepo.save(zapLago);
    	//fin MATERIALS

    	//USER ADMIN
        MyUser admin = new MyUser();
        admin.setFirstname("administrador");
        admin.setSurname("admin");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        Set<Rol> roles = new HashSet<>();
        roles.add(adminRol);
        roles.add(managerRol);
        roles.add(userRol);
        admin.setRoles(roles);
        userService.addUser(admin);
        //fin USER ADMIN
        
        //USER MANAGER
        MyUser manager = new MyUser();
        manager.setFirstname("manager");
        manager.setSurname("manager");
        manager.setUsername("manager");
        admin.setPassword(passwordEncoder.encode("manager"));
        Set<Rol> rolesManager = new HashSet<>();
        rolesManager.add(managerRol);
        rolesManager.add(userRol);
        admin.setRoles(rolesManager);
        userService.addUser(manager);
        //fin USER MANAGER
        
        */
    }
}

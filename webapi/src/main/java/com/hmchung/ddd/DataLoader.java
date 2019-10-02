package com.hmchung.ddd;

import com.hmchung.ddd.domain.*;
import com.hmchung.ddd.domain.enumeration.ModuleType;
import com.hmchung.ddd.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    final private FormFieldRepository formFieldRepository;
    final private MultiValuedFieldRepository multiValuedFieldRepository;
    final private ModuleRoleRepository moduleRoleRepository;
    final private ModuleRepository moduleRepository;
    final private PermissionActionRepository permissionActionRepository;
    final private SubModuleRepository subModuleRepository;
    final private PermissionRepository permissionRepository;

    private ModuleRole accountsUserRole, accountsManagerRole, salesUserRole, salesManagerRole;
    private Module sellingModule;
    private SubModule customer,quotation, order, item;
    private Permission customerPermissionForSalesUser;
    private Permission customerPermissionForSalesManager;
    private Permission customerPermissionForAccountUser;
    private Permission customerPermissionForAccountManager;
    private Permission customerPermissionForSalesMasterManager;

    public DataLoader(FormFieldRepository formFieldRepository, MultiValuedFieldRepository multiValuedFieldRepository, ModuleRoleRepository moduleRoleRepository, ModuleRepository moduleRepository, PermissionActionRepository permissionActionRepository, SubModuleRepository subModuleRepository, PermissionRepository permissionRepository) {
        this.formFieldRepository = formFieldRepository;
        this.multiValuedFieldRepository = multiValuedFieldRepository;
        this.moduleRoleRepository = moduleRoleRepository;
        this.moduleRepository = moduleRepository;
        this.permissionActionRepository = permissionActionRepository;
        this.subModuleRepository = subModuleRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        initModuleRoles();

        initModules();

        initSubModules();

        initPermissions();

        initFormFieldValue();
    }

    private void initPermissions() {
        customerPermissionForSalesUser = new Permission();
        customerPermissionForSalesUser.setName("Sales User");
        customerPermissionForSalesUser.setSubmodule(customer);

        customerPermissionForSalesManager = new Permission();
        customerPermissionForSalesManager.setName("Sales Manager");
        customerPermissionForSalesManager.setSubmodule(customer);

        customerPermissionForAccountUser = new Permission();
        customerPermissionForAccountUser.setName("Account User");
        customerPermissionForAccountUser.setSubmodule(customer);

        customerPermissionForAccountManager = new Permission();
        customerPermissionForAccountManager.setName("Account Manager");
        customerPermissionForAccountManager.setSubmodule(customer);

        customerPermissionForSalesMasterManager = new Permission();
        customerPermissionForSalesMasterManager.setName("Sales Master Manager");
        customerPermissionForSalesMasterManager.setSubmodule(customer);

        permissionRepository.saveAll(Arrays.asList(customerPermissionForSalesUser, customerPermissionForSalesManager, customerPermissionForAccountUser, customerPermissionForAccountManager, customerPermissionForSalesMasterManager));

        initPermissionActions(customerPermissionForSalesUser);
        initPermissionActions(customerPermissionForSalesManager);
        initPermissionActions(customerPermissionForAccountUser);
        initPermissionActions(customerPermissionForAccountManager);
        initPermissionActions(customerPermissionForSalesMasterManager);
    }

    private void initSubModules() {
        logger.info("Populate SubModules ...");
        customer = new SubModule();
        customer.setDescription("Buyer of Goods and Services.");
        customer.setName("Customer");
        customer.setModule(sellingModule);

        quotation = new SubModule();
        quotation.setDescription("");
        quotation.setName("Quotation");
        quotation.setModule(sellingModule);

        order = new SubModule();
        order.setDescription("");
        order.setName("Order");
        order.setModule(sellingModule);

        item = new SubModule();
        item.setDescription("");
        item.setName("Item");
        item.setModule(sellingModule);

        subModuleRepository.saveAll(Arrays.asList(customer, quotation, order, item));
    }

    private void initPermissionActions(Permission permission) {
        logger.info("Populate PermissionAction ...");
        PermissionAction create = new PermissionAction();
        create.setPermission(permission);
        create.setName("CREATE");

        PermissionAction delete = new PermissionAction();
        delete.setPermission(permission);
        delete.setName("DELETE");

        PermissionAction email = new PermissionAction();
        email.setPermission(permission);
        email.setName("EMAIL");

        PermissionAction exportData = new PermissionAction();
        exportData.setPermission(permission);
        exportData.setName("EXPORT");

        PermissionAction importData = new PermissionAction();
        importData.setPermission(permission);
        importData.setName("IMPORT");

        PermissionAction print = new PermissionAction();
        print.setPermission(permission);
        print.setName("PRINT");

        PermissionAction read = new PermissionAction();
        read.setPermission(permission);
        read.setName("READ");

        PermissionAction report = new PermissionAction();
        report.setPermission(permission);
        report.setName("REPORT");

        PermissionAction share = new PermissionAction();
        share.setPermission(permission);
        share.setName("SHARE");

        PermissionAction write= new PermissionAction();
        write.setPermission(permission);
        write.setName("WRITE");

        permissionActionRepository.saveAll(Arrays.asList(create, delete, email, exportData, importData, print, read, report, share, write));
    }

    private void initModuleRoles() {
        logger.info("Populate Roles ...");

        accountsUserRole = new ModuleRole();
        accountsUserRole.setName("Accounts User");

        accountsManagerRole = new ModuleRole();
        accountsManagerRole.setName("Accounts Manager");

        salesUserRole = new ModuleRole();
        salesUserRole.setName("Sales User");

        salesManagerRole = new ModuleRole();
        salesManagerRole.setName("Sales Manager");

        ModuleRole salesMasterManagerRole = new ModuleRole();
        salesMasterManagerRole.setName("Sales Master Manager");

        moduleRoleRepository.saveAll(Arrays.asList(accountsUserRole, accountsManagerRole, salesUserRole, salesManagerRole, salesMasterManagerRole));

        ModuleRole stockManagerRole = new ModuleRole();
        stockManagerRole.setName("Stock Manager");
        moduleRoleRepository.saveAll(Arrays.asList(stockManagerRole));
    }

    private void initModules() {
        logger.info("Populate Modules ...");
        sellingModule = new Module();
        sellingModule.setName("Selling");
        sellingModule.setOwner("Administrator");
        sellingModule.setPageName("Selling");
        sellingModule.setType(ModuleType.PAGE);
        sellingModule.setRoles(new HashSet<>(Arrays.asList(accountsUserRole, accountsManagerRole, salesUserRole, salesManagerRole)));
        moduleRepository.save(sellingModule);
    }

    private void initFormFieldValue() {
        logger.info("Populate FormFieldValue ...");

        FormField nameFormField = new FormField(1L, "text", "text", "NAME", false);
        nameFormField.setSubModule(customer);
        formFieldRepository.save(nameFormField);

        FormField ageFormField = new FormField(2L, "text", "text", "AGE", false);
        ageFormField.setSubModule(customer);
        formFieldRepository.save(ageFormField);

        FormField countryFormField = new FormField(3L, "combo", "combo", "COUNTRY", true);
        countryFormField.setSubModule(customer);
        formFieldRepository.save(countryFormField);

        multiValuedFieldRepository.save(new MultiValuedField(1L,"India", 3L));
        multiValuedFieldRepository.save(new MultiValuedField(2L,"Japan", 3L));
        multiValuedFieldRepository.save(new MultiValuedField(3L,"Korea", 3L));
    }
}
# Api spring Heroku mysql
Dependency maven Mysql
````
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.29</version>
</dependency>

````

properties-deve
````
spring.datasource.url=jdbc:mysql://localhost:3306/curso_spring
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driverClassName=com.mysql.jdbc.Driver

spring.jpa.database-platform = org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true



````





## CRUD

Iniciando </br>
git clone https://github.com/rafaelmarcolino22/Api_spring.git </br>
cd Api_spring </br>
git remote set-url origin https://github.com/rafaelmarcolino22/backend-Spring-crud.git </br>
$ git push -u origin main


## Validation


import javax.validation.constraints.NotEmpty;</br>


		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>6.0.13.Final</version>
		</dependency>

		<dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
			<version>2.0.1.Final</version>
		</dependency>



## Pagination URL
````
http://localhost:8080/categorias/page?linesPerPage=3&page=0

````
### Create Validaion CPF CNPJ

````

path(\services.validation)

clienteInsert

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
@Constraint(validatedBy = NomeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)


public @interface Nome {
 String message() default "Erro de validação";
 Class<?>[] groups() default {};
 Class<? extends Payload>[] payload() default {};
}


ClienteInsertValidation

Validator:
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class NomeValidator implements ConstraintValidator<Nome, Tipo> {
 @Override
 public void initialize(Nome ann) {
 }
 @Override
 public boolean isValid(Tipo objDto, ConstraintValidatorContext context) {
 List<FieldMessage> list = new ArrayList<>();
 
 // inclua os testes aqui, inserindo erros na lista
 
 for (FieldMessage e : list) {
 context.disableDefaultConstraintViolation();
 context.buildConstraintViolationWithTemplate(e.getMessage())
 .addPropertyNode(e.getFieldName()).addConstraintViolation();
 }
 return list.isEmpty();
 }
}

````

## Validação por cpf ou cnpj

````
//path (services\validation\input)
//Cliente Insert Validation

//Fonte: https://gist.github.com/adrianoluis/5043397d378ae506d87366abb0ab4e30
public class BR {
	// CPF
 private static final int[] weightSsn = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

 // CNPJ
 private static final int[] weightTin = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

 private static int calculate(final String str, final int[] weight) {
     int sum = 0;
     for (int i = str.length() - 1, digit; i >= 0; i--) {
         digit = Integer.parseInt(str.substring(i, i + 1));
         sum += digit * weight[weight.length - str.length() + i];
     }
     sum = 11 - sum % 11;
     return sum > 9 ? 0 : sum;
 }

 /**
  * Valida CPF
  *
  * @param ssn
  * @return
  */
 public static boolean isValidCPF(final String ssn) {
     if ((ssn == null) || (ssn.length() != 11) || ssn.matches(ssn.charAt(0) + "{11}")) return false;

     final Integer digit1 = calculate(ssn.substring(0, 9), weightSsn);
     final Integer digit2 = calculate(ssn.substring(0, 9) + digit1, weightSsn);
     return ssn.equals(ssn.substring(0, 9) + digit1.toString() + digit2.toString());
 }

 /**
  * Valida CNPJ
  *
  * @param tin
  * @return
  */
 public static boolean isValidCNPJ(final String tin) {
     if ((tin == null) || (tin.length() != 14) || tin.matches(tin.charAt(0) + "{14}")) return false;

     final Integer digit1 = calculate(tin.substring(0, 12), weightTin);
     final Integer digit2 = calculate(tin.substring(0, 12) + digit1, weightTin);
     return tin.equals(tin.substring(0, 12) + digit1.toString() + digit2.toString());
 }
}
````

### Cliente insert

````

{
    "nome": "sergio",
    "email": "sergio@gmail.com",
    "cpf": "255587888",
    "tipo": 1,
    "telefone1": "478599885",
    "telefone2": "366988858",
    "logadouro": "rua 8",
    "nuero": "45",
    "complemento": "apt 45",
    "cep": "588878",
    "cidadeId": 2
}



````

# Backend-Heroku
# Backend-Heroku

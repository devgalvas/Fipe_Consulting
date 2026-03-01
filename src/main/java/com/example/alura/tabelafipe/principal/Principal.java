package com.example.alura.tabelafipe.principal;

import com.example.alura.tabelafipe.model.Vehicle;
import com.example.alura.tabelafipe.model.VehicleData;
import com.example.alura.tabelafipe.service.DataConversor;
import com.example.alura.tabelafipe.service.GetAPI;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {

    private Scanner input = new Scanner(System.in);
    private GetAPI getApi = new GetAPI();
    private DataConversor conversor = new DataConversor();

    private static final String API_ADRESS = "https://fipe.parallelum.com.br/api/v2";

    public void showMenu() throws JsonProcessingException {

        System.out.println("=== Seja bem vindo à Pesquisa Fipe ===");
        System.out.println(" Para iniciarmos, defina o tipo de veículo que deseja pesquisar " +
                "\n1 - Carros " +
                "\n2 - Motos " +
                "\n3 - Caminhões\n" +
                "Insira a opção desejada: ");

        var opt = input.nextInt();
        input.nextLine();

        var vehicleType = switch (opt) {
            case 1 -> "cars";
            case 2 -> "motorcycles";
            case 3 -> "trucks";
            default -> throw new IllegalStateException("Unexpected value: " + opt);
        };

        var json = getApi.getData(API_ADRESS + "/" + vehicleType + "/brands");

        // System.out.println(json);

        var brands = conversor.getList(json, VehicleData.class);

        // Brands
        System.out.println("=== Marcas de veículos da categoria escolhida === ");
        brands.stream()
                .sorted(Comparator.comparing(VehicleData::code))
                .forEach(System.out::println);

        System.out.println("Insira o código para a consulta da marca do veiculo: ");
        var vehicleBrand = input.nextLine();

        var adress = API_ADRESS + "/" + vehicleType + "/brands/" + vehicleBrand + "/models/";

        var jsonBrands = getApi.getData(adress);

        // Essa linha estava causado problemas pois há diferença da v1 pra v2 da API
        // agora ela devolve um endpoint com 2 listas dentro, assim como as marcas
        var modelList = conversor.getList(jsonBrands, VehicleData.class);

        // o arquivo models acaba sendo inútil, pois agora basta acessar por uma listas de listas de dados do veiculo

        System.out.println("\n=== Modelos da marca === ");

        modelList.stream()
                .sorted(Comparator.comparing(VehicleData::code))
                .forEach(System.out::println);

        System.out.println("Insira agora o código do modelo que deseja saber mais informações: ");
        var modelId = input.nextLine();

        var adressYears = adress + "/" + modelId + "/years/";

        var jsonModelYears = getApi.getData(adressYears);
        var modelYearList = conversor.getList(jsonModelYears, VehicleData.class);

        System.out.println("\n=== Anos do Modelo === ");
        modelYearList.stream()
                .sorted(Comparator.comparing(VehicleData::code))
                .forEach(System.out::println);

        System.out.println("Insira o ano que deseja consultar: ");
        var yearId = input.nextLine();

        var definitiveAdress = adressYears + yearId;
        json = getApi.getData(definitiveAdress);

        var vehicle = conversor.convertData(json, Vehicle.class);

        System.out.println("\n=== Veículo Encontrado ===");
        System.out.println(
                "Ano: " + vehicle.modelYear() + "\n" +
                        "| Valor: " + vehicle.value() + "\n" +
                        "| Marca: " + vehicle.brand() + "\n" +
                        "| Modelo: " + vehicle.model() + "\n"

        );
    }
}
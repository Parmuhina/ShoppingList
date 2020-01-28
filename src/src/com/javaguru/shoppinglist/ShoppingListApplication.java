package src.com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class ShoppingListApplication {

    public static void main(String[] args) {
        Map<Long, Product> productRepository = new HashMap<>();
        Long productIdSequence = 0L;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                System.out.println("4. Change");
                System.out.println("5. Delete");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        System.out.println("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter product price: ");
                        BigDecimal price = new BigDecimal(scanner.nextLine());
                        System.out.println("Enter product category: ");
                        String category = scanner.nextLine();
                        System.out.println("Enter product percents: ");
                        BigDecimal percent = new BigDecimal(scanner.nextLine());


                        Product product = new Product();
                        product.setName(name);
                        product.setPrice(price);
                        product.setCategory(category);
                        product.setPercent(percent);

                        product.setId(productIdSequence);

                        ShoppingValidation victim = new ShoppingValidation(name, price, category, percent);
                        victim.productValidationName(name);

                        while (victim.productValidationName(name) == 1) {
                            product.setName(name);
                            try {
                                System.out.println("Enter product name: ");
                                name = scanner.nextLine();
                                switch (victim.productValidationName(name)) {
                                    case 2:
                                        System.out.println("Product name is correct. ");
                                }
                            } catch (Exception e) {
                                System.out.println("Product name need to be more than 1 simbol. Try one more time. ");
                            }
                        }

                        while (victim.productValidationPrice(price) == 1) {
                            product.setPrice(price);
                            try {
                                System.out.println("Enter product price: ");
                                price = new BigDecimal(scanner.nextLine());
                                switch (victim.productValidationPrice(price)) {
                                    case 2:
                                        System.out.println("Product price is correct. ");
                                }
                            } catch (Exception e) {
                                System.out.println("Product price need to be more than 0 value. Try one more time. ");
                            }
                        }

                        while (victim.productValidationPercent(percent) == 1) {
                            product.setPercent(percent);
                            try {
                                System.out.println("Enter product percent: ");
                                percent = new BigDecimal(scanner.nextLine());
                                switch (victim.productValidationPercent(percent)) {
                                    case 2:
                                        System.out.println("Product percent is correct. ");
                                }
                            } catch (Exception e) {
                                System.out.println("Product percent need to be less or equal than 1 value." +
                                        " Try one more time. ");
                            }
                        }

                        System.out.println("Do you want to enter text about product? Yes - press 7. No - press 8.");
                        Integer answer = Integer.valueOf(scanner.nextLine());
                        //System.out.println("Enter product text: ");
                        //String text = scanner.nextLine();
                        //product.setText(text);
                        while (answer!=7 && answer!=8) {
                            System.out.println("Do you want to enter text about product? Yes - press 7. No - press 8.");
                            answer = Integer.valueOf(scanner.nextLine());
                            try {


                                switch (answer) {
                                    case 7:
                                        System.out.println("Enter product text: ");
                                        String text = scanner.nextLine();
                                        product.setText(text);
                                    case 8:
                                        product.setText(" ");
                                }
                            }catch(Exception e){
                                System.out.println("try one more time.");
                            }
                        }


                        productRepository.put(productIdSequence, product);
                        productIdSequence++;
                        System.out.println("Result: " + product.getId());
                    case 2:
                        System.out.println("Enter product id: ");
                        long id = scanner.nextLong();
                        Product findProductResult = productRepository.get(id);
                        System.out.println(findProductResult);
                    case 3:
                        return;

                    case 4:
                        System.out.println("Enter product id for changing: ");
                        long id1 = scanner.nextLong();
                        Product changeProductResult = productRepository.remove(id1);
                        System.out.println("Changed product "+changeProductResult);

                        break ;



                    case 5:
                        System.out.println("Enter product id for deleting: ");
                        id = scanner.nextLong();
                        Product deleteProductResult = productRepository.remove(id);
                        System.out.println("Product "+deleteProductResult+"is deleted.");
                        return;

                }

            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}

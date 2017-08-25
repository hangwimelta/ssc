package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rewards.RewardNetwork;
import rewards.internal.RewardNetworkImpl;
import rewards.internal.account.AccountRepository;
import rewards.internal.account.JdbcAccountRepository;
import rewards.internal.restaurant.JdbcRestaurantRepository;
import rewards.internal.restaurant.RestaurantRepository;
import rewards.internal.reward.JdbcRewardRepository;
import rewards.internal.reward.RewardRepository;

import javax.sql.DataSource;

@Configuration
public class RewardNetworkConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public RewardNetwork rewardNetwork(){
        return new RewardNetworkImpl(accountRepository(), restaurantRepository(), rewardRepository());
    }

    public AccountRepository accountRepository(){
        JdbcAccountRepository jdbcAccountRepository = new JdbcAccountRepository();
         jdbcAccountRepository.setDataSource(dataSource);
         return jdbcAccountRepository;
    }

    public RestaurantRepository restaurantRepository(){
        JdbcRestaurantRepository jdbcRestaurantRepository = new JdbcRestaurantRepository();
        jdbcRestaurantRepository.setDataSource(dataSource);
        return jdbcRestaurantRepository;
    }

    public RewardRepository rewardRepository(){
        JdbcRewardRepository jdbcRewardRepository = new JdbcRewardRepository();
        jdbcRewardRepository.setDataSource(dataSource);
        return jdbcRewardRepository;
    }
}

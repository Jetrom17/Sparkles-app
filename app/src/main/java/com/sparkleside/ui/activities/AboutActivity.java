package com.sparkleside.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.bumptech.glide.Glide;
import com.google.android.material.transition.platform.MaterialSharedAxis;
import com.peekandpop.shalskar.peekandpop.PeekAndPop;
import com.sparkleside.R;
import com.sparkleside.databinding.ActivityAboutBinding;
import com.sparkleside.ui.base.BaseActivity;
import com.sparkleside.ui.components.TeamMemberView;
import dev.trindadedev.ui_utils.UI;

/*
 * A Screen with info about app
 * @author Aquiles Trindade (trindadedev).
 * @author SyntaxSpin (SyntaxSpin)
 */

public class AboutActivity extends BaseActivity {
  private ActivityAboutBinding binding;
  private Intent intent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    binding = ActivityAboutBinding.inflate(getLayoutInflater());
    getWindow().setAllowEnterTransitionOverlap(false);
    MaterialSharedAxis enterTransition = new MaterialSharedAxis(MaterialSharedAxis.X, true);
    enterTransition.addTarget(R.id.coordinator);
    enterTransition.setDuration(400L);
    getWindow().setEnterTransition(enterTransition);
    MaterialSharedAxis returnTransition = new MaterialSharedAxis(MaterialSharedAxis.X, false);
    returnTransition.setDuration(400L);
    returnTransition.addTarget(R.id.coordinator);
    getWindow().setReturnTransition(returnTransition);
    super.onCreate(savedInstanceState);
    setContentView(binding.getRoot());
    configureToolbar();
    configureDevelopers();
    configureLinks();
    configureTeamMembers();
    UI.handleInsetts(binding.getRoot());
  }

  private void configureToolbar() {
    setSupportActionBar(binding.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeButtonEnabled(true);

    binding.toolbar.setNavigationOnClickListener(
        v -> {
          super.onBackPressed();
        });
  }

  private void configureDevelopers() {
    Glide.with(this).load("https://github.com/syntaxspins.png").into(binding.imgSyn);
    Glide.with(this).load("https://github.com/yamenher.png").into(binding.imgYamen);
    Glide.with(this).load("https://github.com/trindadedev13.png").into(binding.imgTrindade);

    peekAndPop(
        "SyntaxSpin",
        "https://github.com/syntaxspins.png",
        getString(R.string.syntaxspin_phrase),
        binding.imgSyn);
    peekAndPop(
        "Yamen",
        "https://github.com/YamenHer.png",
        getString(R.string.yamenher_phrase),
        binding.imgYamen);
    peekAndPop(
        "Aquiles Trindade",
        "https://github.com/trindadedev13.png",
        getString(R.string.trindadedev_phrase),
        binding.imgTrindade);
  }

  private void configureLinks() {
    binding.tg.setOnClickListener(
        v -> {
          openURL("https://www.telegram.me/sparkleseditor");
        });

    binding.github.setOnClickListener(
        v -> {
          openURL("https://github.com/sparkleddevs/sparkleseditor");
        });

    binding.hanzo.setOnClickListener(
        v -> {
          openURL("https://github.com/yamenher");
        });

    binding.syn.setOnClickListener(
        v -> {
          openURL("https://github.com/syntaxspins");
        });

    binding.trindade.setOnClickListener(
        v -> {
          openURL("https://github.com/trindadedev13");
        });
  }

  private void configureTeamMembers() {
    TeamMember(
        "Vivek",
        Role.DEVELOPER,
        "https://github.com/itsvks19",
        getString(R.string.vivek_phrase),
        "0",
        false);
    TeamMember(
        "Rohit Kushvaha",
        Role.DEVELOPER,
        "https://github.com/RohitKushvaha01",
        getString(R.string.rohit_kushvaha_phrase),
        "1",
        false);

    TeamMember(
        "Thiarley Rocha",
        Role.DEVELOPER,
        "https://github.com/thdev-only",
        getString(R.string.thiarley_rocha_phrase),
        "1",
        false);

    TeamMember(
        "NEOAPPS",
        Role.DEVELOPER,
        "https://github.com/neoapps-dev",
        getString(R.string.neoapps_phrase),
        "1",
        false);
    TeamMember(
        "ArtSphere",
        Role.DEVELOPER,
        "https://github.com/ArtSphereOfficial",
        getString(R.string.art_phrase),
        "1",
        false);
    TeamMember(
        "Hanzo",
        Role.DEVELOPER,
        "https://github.com/HanzoDev1375",
        getString(R.string.hanzo_phrase),
        "1",
        false);

    TeamMember(
        "Jeiel Lima Miranda",
        Role.DEVELOPER,
        "https://github.com/jetrom17",
        getString(R.string.jaiel_lima_phrase),
        "1",
        false);
    TeamMember(
        "Ömer SÜSİN",
        Role.PROMOTER,
        "https://github.com/omersusin",
        getString(R.string.omer_phrase),
        "1",
        false);    
    TeamMember(
        "𝙊𝙋𝙏𝙄𝙈𝒊𝒛𝒆𝒓. 𝟚.𝟜.𝟛",
        Role.PROMOTER,
        "https://github.com/matrixguy007",
        getString(R.string.optim_phrase),
        "1",
        false);  
    TeamMember(
        "ZG089",
        Role.DESGINER,
        "https://github.com/zg089",
        getString(R.string.zg_phrase),
        "1",
        false);        

    TeamMember(
        "Alex",
        Role.TRANSLATOR,
        "https://github.com/paxsenix0",
        getString(R.string.alex_phrase),
        "1",
        false);
    TeamMember(
        "Fahim Abdullah",
        Role.TRANSLATOR,
        "https://github.com/nexavo999",
        getString(R.string.nex_phrase),
        "2",
        false);      
  }

  private void peekAndPop(String name, String imageUrl, String phrase, View v) {
    PeekAndPop peekAndPop =
        new PeekAndPop.Builder(this)
            .peekLayout(R.layout.layout_about_preview)
            .longClickViews(v)
            .build();
    ImageView peekChild = peekAndPop.getPeekView().findViewById(R.id.icon);
    Glide.with(this).load(imageUrl).into(peekChild);
    TextView peekTextName = peekAndPop.getPeekView().findViewById(R.id.name);
    peekTextName.setText(name);
    TextView peekTextPhrase = peekAndPop.getPeekView().findViewById(R.id.phrase);
    peekTextPhrase.setText(phrase);
  }

  private void TeamMember(String name, Role role, String url, String phrase, String bg ,boolean hasDivider) {
    var c = new TeamMemberView(this);
    c.setName(name);
    c.setDescription(role.getName(this));
    c.setImageURL(url + ".png");
    c.setURL(url);
    c.setHasDivider(hasDivider);
    c.setBackgroundPosition(bg);
    peekAndPop(name, url + ".png", phrase, c.getRoot());
    binding.team.addView(c);
  }

  private void openURL(String url) {
    Intent i = new Intent(Intent.ACTION_VIEW);
    i.setData(Uri.parse(url));
    startActivity(i);
  }

  public enum Role {
    TRANSLATOR(R.string.about_tag_translator),
    DEVELOPER(R.string.about_tag_developer),
    PROMOTER(R.string.about_tag_promote),
    DESGINER(R.string.about_tag_designer);    
    @StringRes private final int stringResId;

    Role(@StringRes int stringResId) {
      this.stringResId = stringResId;
    }

    public String getName(Context context) {
      return context.getString(stringResId);
    }
  }
}
